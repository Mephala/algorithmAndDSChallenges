package com.gokhanozg.hackerrank.encryption;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll(" ", "");
        int n = s.length();
        int max = BigDecimal.valueOf(Math.sqrt(n)).setScale(0, BigDecimal.ROUND_UP).intValue();
        int rowCount = n / max;
        if (n % max != 0) {
            rowCount++;
        }
        int i = 0;
        int j = 0;
        char[][] chars = new char[rowCount][max];
        while (i < rowCount) {
            int pos = (i * max) + j;
            if (pos < s.length()) {
                chars[i][j] = s.charAt(pos);
            } else {
                chars[i][j] = '0';
            }

            j++;
            if (j == max) {
                i++;
                j = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < max; k++) {
            for (int l = 0; l < chars.length; l++) {
                char c = chars[l][k];
                if (c != '0')
                    sb.append(c);
            }
            sb.append(" ");
        }
        return sb.toString().trim();

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
