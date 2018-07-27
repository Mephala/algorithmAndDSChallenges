package com.gokhanozg.hackerrank.candies;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    static long candies(int n, int[] arr) {
        long[] givenCandies = new long[n];
        givenCandies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                givenCandies[i] = givenCandies[i - 1] + 1;
            } else if (arr[i] == arr[i - 1]) {
                givenCandies[i] = 1;
            } else {
                givenCandies[i] = 1;
                if (givenCandies[i - 1] == 1) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] > arr[j + 1] && givenCandies[j] <= givenCandies[j + 1]) {
                            givenCandies[j] = givenCandies[j + 1] + 1;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        long sum = 0L;
        for (int i = 0; i < givenCandies.length; i++) {
            sum += givenCandies[i];
        }
        return sum;
    }

    // Complete the candies function below.
    static long candiez(int n, int[] arr) {
        long[][] dp = new long[n][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = -1;
        Stack<TempLowPoint> tempLowPoints = new Stack<>();
        for (int i = 1; i < n; i++) {
            long prevCandy = dp[i - 1][1];
            long prevLowPoint = dp[i - 1][2];
            long prevMax = dp[i - 1][0];
            if (arr[i] > arr[i - 1]) {
                dp[i][0] = prevMax + prevCandy + 1;
                dp[i][1] = prevCandy + 1;
                dp[i][2] = i - 1; //moving prevLowPoint to one left
                while (!tempLowPoints.empty() && tempLowPoints.peek().index < i - 1)
                    tempLowPoints.pop(); // previous temp points are useless now.

            } else if (arr[i] == arr[i - 1]) {
                dp[i][0] = prevMax + 1;
                dp[i][1] = 1;
                dp[i][2] = i - 1; //moving prevLowPoint to one left
                while (!tempLowPoints.empty() && tempLowPoints.peek().index < i - 1)
                    tempLowPoints.pop(); // previous temp points are useless now.


            } else {
                if (prevCandy == 1) {
                    if (tempLowPoints.size() > 0) {
                        TempLowPoint tempLowPoint = tempLowPoints.peek();
                        tempLowPoint.attempt--;
                        if (tempLowPoint.attempt == 0) tempLowPoints.pop();
                        //we have low point attempt
                        long toBeInceremented = i - tempLowPoint.index - 1;
                        prevMax += toBeInceremented;
                        dp[i][0] = prevMax + 1;
                        dp[i][1] = 1;
                        dp[i][2] = prevLowPoint; //low point doesn't change.
                    } else {
                        // prev element has 1 candy, but needs more!
                        long toBeInceremented = i - prevLowPoint - 1;
                        prevMax += toBeInceremented;
                        dp[i][0] = prevMax + 1;
                        dp[i][1] = 1;
                        dp[i][2] = prevLowPoint; //low point doesn't change.
                    }

                } else {
                    long pointDifference = prevCandy - 1;
                    //can safely add 1 here.
                    dp[i][0] = prevMax + 1;
                    dp[i][1] = 1;
                    dp[i][2] = prevLowPoint; //low point doesn't change.
                    if (pointDifference > 1) {
                        long tempLowPointAttempt = pointDifference - 1;
                        long tmpLowPointIndex = i - 1;
                        tempLowPoints.add(new TempLowPoint(tmpLowPointIndex, tempLowPointAttempt));
                    }
                }
            }
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
        System.out.println(result);

        scanner.close();
    }

    static class TempLowPoint {
        long index, attempt;

        public TempLowPoint(long index, long attempt) {
            this.index = index;
            this.attempt = attempt;
        }

    }
}
