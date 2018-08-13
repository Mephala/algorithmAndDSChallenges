package com.gokhanozg.hackerrank.xorSequence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the xorSequence function below.
    static long xorSequence(long l, long r) {


        long prev = 0L;
        long index = prevZeroIndex(l);
        while (index <= l) {
            prev = prev ^ index;
            index++;
        }
        long start = prev;
        while (index <= r) {
            prev = prev ^ index;
            start ^= prev;
            index++;
        }
        return start;

    }

    static long prevZeroIndex(long n) {
        if ((n & (n - 1)) == 0) {
            return n - 1;
        } else {
            double log = Math.pow(n, 0.5d);
            return (long) (Math.pow(2, new BigDecimal(log).setScale(0, BigDecimal.ROUND_DOWN).doubleValue()) - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            long l = Long.parseLong(lr[0]);

            long r = Long.parseLong(lr[1]);

            long result = xorSequence(l, r);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
