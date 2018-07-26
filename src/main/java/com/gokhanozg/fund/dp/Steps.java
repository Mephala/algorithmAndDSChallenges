package com.gokhanozg.fund.dp;

/**
 * Created by Mephalay on 26-Jul-18.
 */
public class Steps {

    public static void main(String[] args) {
        final int step = 10;
        long[] dp = new long[step + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[step]);
    }
}
