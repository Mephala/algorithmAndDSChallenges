package com.gokhanozg.hackerrank.loveLetterMystery;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int changes = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            int c = chars[i];
            int target = chars[chars.length - i - 1];
            changes += Math.abs(c - target);
        }
        return changes;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
