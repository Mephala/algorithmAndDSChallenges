package com.gokhanozg.hackerrank.organizingContainers;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] containers) {
        long[] containerSums = new long[containers.length];
        long[] ballSums = new long[containers.length];
        for (int i = 0; i < containers.length; i++) {
            long containerSum = 0L;
            long ballSum = 0L;
            for (int j = 0; j < containers.length; j++) {
                containerSum += containers[i][j];
                ballSum += containers[j][i];
            }
            containerSums[i] = containerSum;
            ballSums[i] = ballSum;
        }
        return Arrays.equals(containerSums, ballSums) ? "Possible" : "Impossible";

    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println(result);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
