package com.gokhanozg.hackerrank.theTimeInWords;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Integer, String> words = new HashMap<>();

    static {
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "quarter");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");
        words.put(20, "twenty");
        words.put(30, "half");
    }

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        if (m == 0) {
            return words.get(h) + " o' clock";
        } else {
            if (m < 15) {
                if (m == 1) {
                    return "one minute past " + words.get(h);
                } else {
                    return words.get(m) + " minutes past " + words.get(h);
                }
            } else if (m == 15) {
                return "quarter past " + words.get(h);
            } else if (m < 30) {
                String prefix = words.get((m / 10) * 10);
                String postfix = words.get(m % 10);
                return prefix + " " + postfix + " minutes past " + words.get(h);
            } else if (m == 30) {
                return "half past " + words.get(h);
            } else if (m < 45) {
                int to = 60 - m;
                String prefix = words.get((to / 10) * 10);
                String postfix = words.get(to % 10);
                int hn = h + 1;
                if (hn == 13) hn = 1;
                return prefix + " " + postfix + " minutes to " + words.get(hn);
            } else if (m == 45) {
                int hn = h + 1;
                if (hn == 13) hn = 1;
                return "quarter to " + words.get(hn);
            } else {
                int hn = h + 1;
                if (hn == 13) hn = 1;
                if (m == 59) {
                    return "one minute to " + words.get(hn);
                } else {
                    return words.get(60 - m) + " minutes to " + words.get(hn);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
