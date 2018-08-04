package com.gokhanozg.hackerrank.strangeCounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        double prev = 0;
        double limit = 3;
        double pow = 0;
        while (limit < t) {
            prev = limit;
            pow++;
            limit += 3 * Math.pow(2d, pow);
        }
        if (pow == 0) {
            return (long) (limit - t + 1);
        } else {
            long start = (long) (prev + 1);
            long dif = t - start;
            long counter = (long) (limit - prev);
            return counter - dif;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
