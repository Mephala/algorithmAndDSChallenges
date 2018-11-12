package com.gokhanozg.custom;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gokhan Ozgozen on 12-Nov-18.
 */
public class Test2 {

    public static void main(String[] args) {
        Map<T, String> map = new HashMap<>();
        T t = new T();
        t.id = 2;
        t.value = "c";
        map.put(t, "a");
        T t2 = new T();
        t.id = 2;
        t.value = "c";
        map.put(t2, "b");
        System.out.println(map.size());
        System.out.println(map.get(t));
        System.out.println(map.get(t2));

    }

    static class T {
        int id;
        String value;

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {

            return 0;
        }
    }
}
