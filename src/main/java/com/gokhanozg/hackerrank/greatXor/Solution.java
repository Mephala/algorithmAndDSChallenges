package com.gokhanozg.hackerrank.greatXor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the theGreatXor function below.
    static long theGreatXor(long x) {
        if (x == 1) {
            return 0;
        }
        String binary = new BigInteger(Long.valueOf(x).toString()).toString(2);
        binary = binary.substring(1); //omiting first 1.
        long allperm = (long) Math.pow(2, binary.length()) - 1; // omiting zero case.
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                int rem = binary.length() - i - 1;
                if (rem > 0) {
                    allperm -= Math.pow(2, rem);
                } else {
                    allperm--;
                }
            }
        }
        return allperm;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long x = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = theGreatXor(x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
