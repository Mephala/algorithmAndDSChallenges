package com.gokhanozg.fund.dp;

/**
 * Created by Mephalay on 26-Jul-18.
 */
public class Rods {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10};
        final int rodLen = 5;
        int[] dp = new int[rodLen + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j <= rodLen; j++) {
                int current = dp[j];
                int tmp = dp[j - i - 1] + prices[i];
                dp[j] = Math.max(tmp, current);
            }
        }
        System.out.println(dp[rodLen]);
    }
}
