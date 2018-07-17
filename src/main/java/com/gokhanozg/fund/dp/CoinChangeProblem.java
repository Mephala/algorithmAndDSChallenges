package com.gokhanozg.fund.dp;

import java.util.Arrays;

/**
 * Created by Mephalay on 17-Jul-18.
 */
public class CoinChangeProblem {

    public static void main(String[] args) {
        final int amount = 6;
        final int[] coins = new int[]{1, 3, 4};
        // creating dynamic array
        int[] optimals = new int[(amount + 1)];
        for (int i = 0; i < optimals.length; i++) {
            optimals[i] = -1;
        }
        optimals[0] = 0;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                int previousOptimal = optimals[j];
                int previousPoint = j - coins[i];
                int newValue = optimals[previousPoint] + 1;
                if (previousOptimal == -1) {
                    optimals[j] = newValue;
                } else if (newValue < previousOptimal) {
                    optimals[j] = newValue;
                } else {
                    // We can pay this price with lesser amount of coins.
                }
            }

        }
        System.out.println(optimals[6]);

    }
}
