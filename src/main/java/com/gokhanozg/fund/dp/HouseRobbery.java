package com.gokhanozg.fund.dp;

import java.util.Arrays;

/**
 * Created by Gokhan Ozgozen on 26-Jul-18.
 */
public class HouseRobbery {

    public static void main(String[] args) {
        int[] h = new int[]{1, 2, 3, 4, 5};
//        final int len = 30000;
//        Random r = new Random();
//        int[] h = new int[len];
//        for (int i = 0; i < len; i++) {
//            h[i] = r.nextInt(100);
//        }
        System.out.println("Max = " + findMax(h));
        System.out.println("Max = " + findMaxDp(h));
    }

    private static int findMaxDp(int[] h) {
        int[] dp = new int[h.length + 1];
        dp[0] = h[0];
        boolean adj = true;
        for (int i = 1; i < h.length; i++) {
            if (adj) {
                if (i - 2 < 0) {
                    if (h[i] > h[i - 1]) {
                        adj = true;
                        dp[i] = h[i];
                    } else {
                        adj = false;
                        dp[i] = dp[i - 1];
                    }
                } else {
                    int discAdjv = dp[i - 2] + h[i];
                    if (discAdjv > dp[i - 1]) {
                        adj = true;
                        dp[i] = discAdjv;
                    } else {
                        adj = false;
                        dp[i] = dp[i - 1];
                    }
                }
            } else {
                if (h[i] > 0) {
                    adj = true;
                    dp[i] = dp[i - 1] + h[i];
                } else {
                    adj = false;
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[h.length - 1];
    }

    private static int findMax(int[] h) {
        int max = -1;
        for (int i = 0; i < h.length; i++) {
            if (i - 2 < 0) {
                if (i + 2 < h.length - 1)
                    max = Math.max(max, h[i] + findMax(Arrays.copyOfRange(h, i + 2, h.length)));
                else
                    max = Math.max(max, h[i]);
            } else {
                if (i + 2 < h.length - 1) {
                    int val = findMax(Arrays.copyOfRange(h, 0, i - 1)) + h[i] + findMax(Arrays.copyOfRange(h, i + 2, h.length));
                    max = Math.max(max, val);
                } else
                    max = Math.max(max, findMax(Arrays.copyOfRange(h, 0, i - 1)) + h[i]);
            }
        }
        return max;
    }
}
