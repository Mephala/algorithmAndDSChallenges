package com.gokhanozg.codility.sorting.numberOfDiscIntersections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int solution(int[] A) {
        // idea, sort the disks based on their "rightMost" point, do a binary search for each element to
        // find which disk it includes. O(n) = nlogn variant algorithm.

        // write your code in Java SE 8
        List<Disk> diskList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            diskList.add(new Disk(i, A[i]));
        }
        Collections.sort(diskList, new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                return Long.valueOf(o1.rightmost).compareTo(o2.rightmost);
            }
        });
        long totalIntersection = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            Disk rightMostDisk = diskList.get(i);
            totalIntersection = totalIntersection + findIntersections(rightMostDisk, i, diskList);
            if (totalIntersection > 1E7) {
                return -1;
            }
        }
        return (int) totalIntersection;

    }

    private long findIntersections(Disk rightMostDisk, int i, List<Disk> diskList) {
        int high = i - 1;
        int low = 0;
        long searchRightMost = rightMostDisk.leftmost;
        int leftMostPoint = i;
        while (high >= low) {
            int mid = (high + low) / 2;
            Disk midDisk = diskList.get(mid);
            if (midDisk.rightmost >= searchRightMost) {
                //go left
                high = mid - 1;
                leftMostPoint = mid;
            } else {
                //go right
                low = mid + 1;
            }
        }
        return i - leftMostPoint;
    }

    class Disk {
        long rightmost;
        long leftmost;

        Disk(int origin, int r) {
            this.rightmost = (long) origin + (long) r;
            this.leftmost = (long) origin - (long) r;
            if (leftmost < 0) {
                leftmost = 0; // no need to calculate negative zones, no disk originates at negative zone.
            }
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "rightmost=" + rightmost +
                    ", leftmost=" + leftmost +
                    '}';
        }
    }
}