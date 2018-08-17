package com.gokhanozg.codility.slalomSkiing;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.Arrays;

class Solution {
    public int solution(int[] A) {
        int[] idp = new int[A.length];
        int[] ddp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            idp[i] = 1;
            ddp[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    idp[i] = Math.max(idp[i], idp[j] + 1);
                }
                if (A[i] < A[j]) {
                    ddp[i] = Math.max(ddp[i], ddp[j] + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int[] rem = Arrays.copyOfRange(A, i, A.length);
            int remOpt = calculateSingleTurnOptimal(rem);
            max = Math.max(max, idp[i] + remOpt - 1);
//            int v1 = idp[i] + remOpt - 1;
//            int v2 = ddp[i] + remOpt - 1;
//            int tmpmax = v1 > v2 ? v1 : v2;
//            if (tmpmax > max) {
//                max = tmpmax;
//            }
        }
        return max;

    }

    private int calculateSingleTurnOptimal(int[] A) {
        int[] m = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            m[A.length - 1 - i] = A[i];
        }
        int[] idp = new int[A.length];
        int[] ddp = new int[A.length];
        int[] idpm = new int[A.length];
        int[] ddpm = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            idp[i] = 1;
            ddp[i] = 1;
            idpm[i] = 1;
            ddpm[i] = 1;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    idp[i] = Math.max(idp[i], idp[j] + 1);
                }
                if (A[i] < A[j]) {
                    ddp[i] = Math.max(ddp[i], ddp[j] + 1);
                }
            }
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                if (m[i] > m[j]) {
                    idpm[i] = Math.max(idpm[i], idpm[j] + 1);
                }
                if (m[i] < m[j]) {
                    ddpm[i] = Math.max(ddpm[i], ddpm[j] + 1);
                }
            }
        }
        return findSingleTurnOptimal(idp, idpm, ddp, ddpm);
    }

    private int findSingleTurnOptimal(int[] idp, int[] idpm, int[] ddp, int[] ddpm) {
        int n = ddp.length;
        int id = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            id = Math.max(id, idp[i] + idpm[n - 1 - i] - 1);
        }
        int di = Integer.MIN_VALUE;
        for (int i = 0; i < idpm.length; i++) {
            di = Math.max(di, ddp[i] + ddpm[n - 1 - i] - 1);
        }
        int inc = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            inc = Math.max(inc, idp[i]);
        }
        int d = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            d = Math.max(ddp[i], d);
        }
        return Math.max(d, Math.max(inc, Math.max(id, di)));
    }

}