package com.gokhanozg.fund.caterpillar;

import java.util.Random;

/**
 * Created by Mephalay on 14-Jul-18.
 */
public class TestImp {

    public static void main(String[] args) {
        int len = 100;
        final int complexityCoeff = (int) 1E6;
        System.out.println("true," + findSumExists(new int[]{6, 2, 7, 4, 1, 3, 6}, 12));
        Random r = new Random();

        int[] t1 = new int[len];
        for (int i = 0; i < len; i++) {
            t1[i] = r.nextInt();
        }
        long start = System.nanoTime();
        System.out.println(findSumExists(t1, r.nextInt()));
        long diff1 = System.nanoTime() - start;
        len = (len * complexityCoeff);
        t1 = new int[len];
        for (int i = 0; i < t1.length; i++) {
            t1[i] = r.nextInt();
        }
        start = System.nanoTime();
        System.out.println(findSumExists(t1, r.nextInt()));
        long diff2 = System.nanoTime() - start;
        System.out.println("Dif1 :" + diff1);
        System.out.println("Dif2 :" + diff2);
        System.out.println("linear diff:" + 1E6 + ", real diff:" + (double) diff2 / diff1);
    }

    public static boolean findSumExists(int[] arr, int val) {
        int front = 0;
        int total = 0;
        for (int back = 0; back < arr.length; back++) {
            while (front < arr.length & arr[front] + total <= val) {
                total += arr[front];
                front++;
            }
            if (total == val)
                return true;
            total -= arr[back];
        }
        return false;
    }
}
