package com.gokhanozg.fund.dp;

/**
 * Created by Gokhan Ozgozen on 27-Jul-18.
 */
public class StockPrice {

    public static void main(String[] args) {
        int bsCount = 3;
        int[] s = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(findMaxProfitDP(s));
    }

    private static int findMaxProfitDP(int[] s) {
        int min = Integer.MAX_VALUE;
        int[] dp = new int[s.length];
        for (int i = 1; i < s.length; i++) {
            min = Math.min(min, s[i]);
            int profit = s[i] - min;
            dp[i] = Math.max(dp[i - 1], profit);
        }
        return dp[s.length - 1];
    }
}
