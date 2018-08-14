package com.gokhanozg.hackerrank.pangram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the pangrams function below.
    static String pangrams(String s) {
        Set<Integer> vals = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int k = Character.toLowerCase(s.charAt(i));
            vals.add(k);
        }
        for (int i = 97; i <= 122; i++) {
            if (!vals.contains(i))
                return "not pangram";
        }
        return "pangram";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
