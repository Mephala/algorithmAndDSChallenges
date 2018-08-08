package com.gokhanozg.hackerrank.absolutePermutation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        Set<Integer> values = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            values.add(i);
        }
        int[] ret = new int[n];
        for (int i = 1; i <= n; i++) {
            int can1 = i + k;
            int can2 = i - k;
            if (can2 < 0) {
                if (!values.contains(can1)) {
                    return null;
                }
                values.remove(can1);
                ret[i - 1] = can1;
            } else if (can1 > n) {
                if (!values.contains(can2)) {
                    return null;
                }
                values.remove(can2);
                ret[i - 1] = can2;
            } else {
                if (values.contains(can2)) {
                    values.remove(can2);
                    ret[i - 1] = can2;
                } else if (values.contains(can1)) {
                    values.remove(can1);
                    ret[i - 1] = can1;
                } else {
                    return null;
                }
            }
        }
        return ret;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);
            if (result != null) {
                for (int i = 0; i < result.length; i++) {
                    bufferedWriter.write(String.valueOf(result[i]));

                    if (i != result.length - 1) {
                        bufferedWriter.write(" ");
                    }
                }
            } else {
                bufferedWriter.write(String.valueOf(-1));
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
