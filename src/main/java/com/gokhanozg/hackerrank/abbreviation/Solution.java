package com.gokhanozg.hackerrank.abbreviation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the abbreviation function below.
    //https://www.hackerrank.com/challenges/abbr/problem
    static String abbreviation(String a, String b) {
        int prevIndex = 0;
        for (int i = 0; i < b.length(); i++) {
            Character c = b.charAt(i);
            for (int j = prevIndex; j < a.length(); j++) {
                Character tmp = a.charAt(j);
                if (Character.isUpperCase(tmp) && !c.equals(tmp)) {
                    return "NO";
                } else if (Character.isLowerCase(tmp) && Character.toUpperCase(tmp) == c) {
                    prevIndex = j + 1;
                    break;
                } else if (Character.isLowerCase(c) && Character.isUpperCase(tmp)) {
                    return "NO";
                }

            }
        }
        return "YES";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
