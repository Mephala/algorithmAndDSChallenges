package com.gokhanozg.hackerrank.funnyString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the funnyString function below.
    static String funnyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String r = sb.toString();
        for (int i = 1; i < s.length(); i++) {
            int s1 = Math.abs(s.charAt(i - 1) - s.charAt(i));
            int r1 = Math.abs(r.charAt(i - 1) - r.charAt(i));
            if (s1 != r1) {
                return "Not Funny";
            }
        }
        return "Funny";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
