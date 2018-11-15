package com.gokhanozg.custom;

/**
 * Created by Gokhan Ozgozen on 15-Nov-18.
 */
public class Hmap {

    private int size = 0;
    private int limit = 16;
    private Bucket[] buckets = new Bucket[limit];

    protected void put(String key, String value) {
        if (size == limit) {
            int oldLim = limit;
            limit += 16;
            Bucket[] newBuckets = new Bucket[limit];
            for (int i = 0; i < oldLim; i++) {
                if (buckets[i] != null) {
                    int spot = getSpot(buckets[i].key);
                    newBuckets[spot] = buckets[i];
                    if (buckets[i].next != null) {
                        Bucket b = buckets[i];
                        while (b.next != null) {
                            b = b.next;
                            int bspot = getSpot(b.key);
                            newBuckets[bspot] = b;
                        }
                    }
                }
            }
            this.buckets = newBuckets;
        }
        int spot = getSpot(key);
        if (buckets[spot] == null) {
            Bucket bucket = new Bucket();
            buckets[spot] = bucket;
            bucket.key = key;
            bucket.val = value;
        } else {
            Bucket bucket = buckets[spot];
            while (bucket.next != null) {
                bucket = bucket.next;
            }
            Bucket newBucket = new Bucket();
            bucket.next = newBucket;
            newBucket.key = key;
            newBucket.val = value;
        }
        size++;
    }

    private int getSpot(String key) {
        int hash = key.hashCode();
        return hash & (limit - 1);
    }

    protected String get(String key) {
        int spot = getSpot(key);
        if (buckets[spot] == null) {
            return null;
        } else if (buckets[spot].next == null) {
            return buckets[spot].val;
        } else {
            Bucket b = buckets[spot];
            if (b.key.equals(key)) {
                return b.val;
            }
            while (!b.key.equals(key)) {
                b = b.next;
                if (b == null) {
                    return null;
                }
            }
            return b.val;
        }
    }

    private class Bucket {
        String val;
        String key;
        Bucket next;
    }

}
