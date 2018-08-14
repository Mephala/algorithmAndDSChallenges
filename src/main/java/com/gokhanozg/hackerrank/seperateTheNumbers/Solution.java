package com.gokhanozg.hackerrank.seperateTheNumbers;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        int len = s.length();
        int half = len / 2;
        half++;
        for (int i = 1; i <= half; i++) {
            if (checkBeautity(s, i)) {
                System.out.println("YES " + s.substring(0, i));
                return;
            }
        }
        System.out.println("NO");
    }

    private static boolean checkBeautity(String s, int slen) {
        if (slen > s.length()) {
            return false;
        }
        int val = Integer.parseInt(s.substring(0, slen));
        val++;
        int sindex = slen;
        int next = sindex + ("" + val).length();
        if (next > s.length()) {
            return false;
        }
        while (s.substring(sindex, next).equals(Integer.valueOf(val).toString())) {
            val++;
            sindex = next;
            next = sindex + ("" + val).length();
            if (sindex == s.length()) {
                return true;
            } else if (sindex > s.length()) {
                return false;
            }
            if (next > s.length()) {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
