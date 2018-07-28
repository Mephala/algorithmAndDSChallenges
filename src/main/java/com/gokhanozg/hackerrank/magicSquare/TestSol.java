package com.gokhanozg.hackerrank.magicSquare;

import java.util.*;

/**
 * Created by Gokhan Ozgozen on 28-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        List<int[][]> mSquares = new ArrayList<>();

        int[][] init = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        Random r = new Random();
        Set<String> matrices = new HashSet<>();
        //362880
        while (mSquares.size() != 362880) {

            int[][] dstMat = generateMat(matrices, r, nums);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(dstMat[i][j]);
                }
            }
            String key = sb.toString();
            if (!matrices.contains(key)) {
                matrices.add(key);
                mSquares.add(dstMat);
            }
        }
        mSquares.removeIf(next -> !isMagic(next));

        System.out.println(mSquares.size());
        System.out.println("********");
        for (int[][] mSquare : mSquares) {
            printM(mSquare);
        }

    }

    private static void printM(int[][] mSquare) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(mSquare[i][j] + ",");
            }
        }
        String s = sb.toString();
        System.out.println(s.substring(0, s.length() - 1));
    }

    private static boolean isMagic(int[][] m) {
        int total = m[0][0] + m[0][1] + m[0][2];
        int sum1 = m[1][0] + m[1][1] + m[1][2];
        int sum2 = m[2][0] + m[2][1] + m[2][2];
        int sum3 = m[0][0] + m[1][0] + m[2][0];
        int sum4 = m[0][1] + m[1][1] + m[2][1];
        int sum5 = m[0][2] + m[1][2] + m[2][2];
        int sum6 = m[0][0] + m[1][1] + m[2][2];
        int sum7 = m[2][0] + m[1][1] + m[0][2];
        return total == sum1 && total == sum2 && total == sum3 && total == sum4 && total == sum5 && total == sum6 && total == sum7;
    }

    private static int[][] generateMat(Set<String> matrices, Random r, Set<Integer> nums) {
        Set<Integer> tmp = new HashSet<>(nums);
        int[][] retval = new int[3][3];
        while (tmp.size() != 0) {
            int val = r.nextInt(9) + 1;
            while (!tmp.contains(val)) val = r.nextInt(9) + 1;
            tmp.remove(val);
            int i = r.nextInt(3);
            int j = r.nextInt(3);
            while (retval[i][j] != 0) {
                i = r.nextInt(3);
                j = r.nextInt(3);
            }
            retval[i][j] = val;
        }

        return retval;
    }


}
