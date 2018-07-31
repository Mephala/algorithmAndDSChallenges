package com.gokhanozg.hackerrank.appendAndDelete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        while (!s.equals(t)) {

            for (int i = 0; i < Math.min(t.length(), s.length()); i++) {
                if (!s.substring(i, i + 1).equals(t.substring(i, i + 1))) {
                    if (i == 0) {
                        k -= s.length();
                        s = "";
                    } else {
                        k -= (s.length() - i);
                        s = s.substring(0, i);
                    }
                    if (k < 0) {
                        return "No";
                    }
                    break;
                }
            }
            if (s.length() > t.length()) {
                int dif = s.length() - t.length();
                k -= dif;
                if (k < 0) {
                    return "No";
                }
                s = s.substring(0, t.length());
            }
            if (!s.equals(t)) {
                if ("".equals(s)) {
                    int dif = t.length() - s.length();
                    k -= dif;
                    s = t;
                    if (k < 0) {
                        return "No";
                    }
                } else {
                    int dif = t.length() - s.length();
                    k -= dif;
                    s = t;
                    if (k < 0) {
                        return "No";
                    } else {
                        return k % 2 == 0 ? "Yes" : "No";
                    }
                }

            }
        }
        return "Yes";
    }

    private static String deleteLast(String s) {
        return s.substring(0, s.length() - 1);
    }

    private static String append(String s, String c) {
        return s + c;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
