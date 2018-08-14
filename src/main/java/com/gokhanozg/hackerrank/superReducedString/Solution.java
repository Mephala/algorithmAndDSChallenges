package com.gokhanozg.hackerrank.superReducedString;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }
        boolean start = false;
        boolean reduceNeed = true;
        while (reduceNeed || !start) {
            start = true;
            boolean reduced = false;
            for (Character aChar : chars) {
                String tmp = s.replaceAll(Character.toString(aChar) + Character.toString(aChar), "");
                if (tmp.length() < s.length()) {
                    reduced = true;
                    s = tmp;
                }
            }
            if (reduced) {
                reduceNeed = true;
            } else {
                reduceNeed = false;
            }
        }
        return "".equals(s) ? "Empty String" : s;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
