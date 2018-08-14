package com.gokhanozg.hackerrank.flippingBits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        String bin = BigInteger.valueOf(n).toString(2);
        int start = 32 - bin.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (i < start) {
                sb.append("1");
            } else {
                sb.append(bin.charAt(i - start) == '0' ? '1' : '0');
            }
        }
        return new BigInteger(sb.toString(), 2).longValue();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
