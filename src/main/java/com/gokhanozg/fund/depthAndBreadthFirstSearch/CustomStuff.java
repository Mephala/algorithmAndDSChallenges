package com.gokhanozg.fund.depthAndBreadthFirstSearch;

import com.gokhanozg.fund.binarySearch.TestImp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by Mephalay on 13-Jul-18.
 */
public class CustomStuff {

    public static void main(String[] args) {
        final int len = (int) 1E7;
        int[] arr = new int[len];
        int[] nums = new int[len];
        Random r = new Random();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int next = r.nextInt();
            while (hs.contains(next))
                next = r.nextInt();
            hs.add(next);
            nums[i] = next;
        }
        long start = System.currentTimeMillis();
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            tree.add(nums[i]);
        }
        long treeStat = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        long arrStat = System.currentTimeMillis() - start;
        System.out.println("treeInit:" + treeStat);
        System.out.println("arrInit:" + arrStat);
        int searchVal = nums[r.nextInt(len)];
        start = System.nanoTime();
        tree.contains(searchVal);
        long differ = System.nanoTime() - start;
        System.out.println("Tree find:" + differ);
        start = System.nanoTime();
        TestImp.manualBinarySearch(arr, searchVal);
        differ = System.nanoTime() - start;
        System.out.println("Array find:" + differ);
    }


}
