package com.gokhanozg.hackerrank.makingAnagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        Map<Character, Integer> s1co = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1co.put(c, s1co.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> s2co = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            s2co.put(c, s2co.getOrDefault(c, 0) + 1);
        }
        int common = 0;
        for (Map.Entry<Character, Integer> s1coEntry : s1co.entrySet()) {
            char c = s1coEntry.getKey();
            int occurence = s1coEntry.getValue();
            if (s2co.containsKey(c)) {
                common += Math.min(occurence, s2co.get(c));
            }
        }
        if (common == 0)
            return s1.length() + s2.length(); // delete all!
        int deletion = 0;
        deletion += s1.length() - common;
        deletion += s2.length() - common;
        return deletion;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
