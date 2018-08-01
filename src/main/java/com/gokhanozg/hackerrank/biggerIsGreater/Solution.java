package com.gokhanozg.hackerrank.biggerIsGreater;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int swapLen = 1;
        while (swapLen < w.length()) {
            for (int i = w.length() - 1; i >= swapLen; i--) {
                char c1 = w.charAt(i);
                char c2 = w.charAt(i - swapLen);
                if (Character.compare(c1, c2) > 0)
                    return swap(w, i, i - swapLen);
            }
            swapLen++;
        }
        return "no answer"; //TODO Fix this/
    }

    private static String swap(String w, int i, int j) {
        StringBuilder sb = new StringBuilder();
        char ic = w.charAt(i);
        char jc = w.charAt(j);
        for (int k = 0; k < w.length(); k++) {
            if (k == i) {
                sb.append(jc);
            } else if (k == j) {
                sb.append(ic);
            } else {
                sb.append(w.charAt(k));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
