package com.gokhanozg.hackerrank.ceasarCipher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        int st = 'a';
        int e = 'z';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean upperCase = Character.isUpperCase(c);
            c = Character.toLowerCase(c);
            if (c >= st && c <= e) {
                char r = changeLetter(c, k);
                if (upperCase) {
                    sb.append(Character.toUpperCase(r));
                } else {
                    sb.append(r);
                }

            } else {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    private static char changeLetter(char c, int k) {
        int s = 'a';
        int e = 'z';
        k = k % 26;
        int val = (((int) c) + k) % (e + 1);
        if (val < s) {
            val = s + val;
        }
        return (char) val;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
