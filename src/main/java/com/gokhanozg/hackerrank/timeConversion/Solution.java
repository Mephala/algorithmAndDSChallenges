package com.gokhanozg.hackerrank.timeConversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        int hourDotIndex = s.indexOf(":");
        int val = Integer.parseInt(s.substring(0, hourDotIndex));

        if ("PM".equals(s.substring(s.length() - 2))) {
            if (val == 12) {
                return s.substring(0, s.length() - 2);
            }
            val += 12;
            val %= 24;
            return val + s.substring(hourDotIndex, s.length() - 2);
        } else {
            if (val == 12) {
                return "00" + s.substring(hourDotIndex, s.length() - 2);
            } else {
                return s.substring(0, s.length() - 2);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
