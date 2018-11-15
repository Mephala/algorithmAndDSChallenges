package com.gokhanozg.custom;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Gokhan Ozgozen on 16-Nov-18.
 */
public class TestHMap {
    public static void main(String[] args) {
        Hmap hmap = new Hmap();
        Map<String, String> cmap = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            String key = UUID.randomUUID().toString();
            String value = UUID.randomUUID().toString();
            cmap.put(key, value);
            hmap.put(key, value);
        }
        for (Map.Entry<String, String> stringEntry : cmap.entrySet()) {
            String key = stringEntry.getKey();
            String value = stringEntry.getValue();
            String hmapValue = hmap.get(key);
            if (!value.equals(hmapValue)) {
                System.err.println("Failed implementation");
                return;
            }
        }
        System.out.println("Correct implementation.");
    }
}
