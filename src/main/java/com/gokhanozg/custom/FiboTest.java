package com.gokhanozg.custom;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Gokhan Ozgozen on 16-Nov-18.
 */
public class FiboTest {

    public static void main(String[] args) {
        final int val = 45;
        ForkJoinPool forkJoinPool = new ForkJoinPool(32);
        long start = System.nanoTime();
        System.out.println(calcFiboRecursively(val));
        long dif = System.nanoTime() - start;
        System.out.println("Normal calc:" + dif);
        ForkJoinTask<Integer> task = new Fibo(val);
        start = System.nanoTime();
        System.out.println(forkJoinPool.invoke(task));
        dif = System.nanoTime() - start;
        System.out.println("ForkJoin calc:" + dif);

        System.out.println(Stream.of("ast", "asdadw").filter(s -> s.equals("ast")).collect(Collectors.toList()));
    }

    private static int calcFiboRecursively(int val) {
        if (val <= 1) {
            return val;
        }
        return calcFiboRecursively(val - 1) + calcFiboRecursively(val - 2);
    }
}
