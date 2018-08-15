package com.gokhanozg.hackerrank.gameOfThrones1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        int singleCount = 0;
        for (Integer value : charCount.values()) {
            if (value % 2 == 1)
                singleCount++;
        }
        if (s.length() % 2 == 1) {
            return singleCount == 1 ? "YES" : "NO";
        } else {
            return singleCount == 0 ? "YES" : "NO";
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
