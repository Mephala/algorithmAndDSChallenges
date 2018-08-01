package com.gokhanozg.hackerrank.serviceLane;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int[][] cases, int[] width) {
        int[] ret = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            int start = cases[i][0];
            int end = cases[i][1];
            int[] slice = Arrays.copyOfRange(width, start, end + 1);
            int min = Integer.MAX_VALUE;
            for (int s : slice) {
                min = Math.min(min, s);
            }
            ret[i] = min;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, cases, width);

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
            System.out.println(result[i]);
        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
