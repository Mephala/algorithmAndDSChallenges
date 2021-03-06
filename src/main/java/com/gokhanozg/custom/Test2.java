package com.gokhanozg.custom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        t2.id = 3;
        t2.value = "d";
        map.put(t2, "b");
        System.out.println(map.size());
        System.out.println(map.get(t));
        System.out.println(map.get(t2));
        Set<T> hashSet = new HashSet<>();
        hashSet.add(t);
        hashSet.add(t2);
        System.out.println(hashSet.size());
        System.out.println(t.equals(t2));


    }

    static class T {
        int id;
        String value;

        @Override
        public boolean equals(Object o) {
            T t = (T) o;
            return id == t.id;
        }

        @Override
        public int hashCode() {

            return 0;
        }
    }
}
