package com.gokhanozg.fund.dijkstra;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by Gokhan Ozgozen on 20-Jul-18.
 */
public class TestImp {

    public static void main(String[] args) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        TreeSet<Integer> t = new TreeSet<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1E6; i++) {
            t.add(i);
        }
        long dif = System.nanoTime() - start;
        System.out.println(dif);
        start = System.nanoTime();
        for (int i = 0; i < 1E6; i++) {
            p.add(i);
        }
        dif = System.nanoTime() - start;
        System.out.println(dif);
    }

    class Nodez implements Comparable<Nodez> {
        Integer val;

        public Nodez(Integer val) {
            this.val = val;
        }

        @Override
        public int compareTo(Nodez o) {
            return val.compareTo(o.val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Nodez)) return false;
            Nodez nodez = (Nodez) o;
            return Objects.equals(val, nodez.val);
        }

        @Override
        public int hashCode() {

            return Objects.hash(val);
        }
    }


}
