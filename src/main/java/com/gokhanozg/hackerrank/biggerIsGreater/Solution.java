package com.gokhanozg.hackerrank.biggerIsGreater;

import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        if (w.length() == 1)
            return "no answer";

        for (int i = w.length() - 2; i >= 0; i--) {
            List<Character> higherChars = new ArrayList<>();
            Map<Character, Integer> higherCharIndex = new HashMap<>();
            for (int j = i + 1; j < w.length(); j++) {
                char c1 = w.charAt(j);
                char c2 = w.charAt(i);
                if (c1 > c2) {
                    higherChars.add(c1);
                    higherCharIndex.put(c1, j);
                }
            }
            if (higherChars.size() > 0) {
                Collections.sort(higherChars);
                int j = higherCharIndex.get(higherChars.get(0));
                String greater = swap(w, i, j);
                String part1 = greater.substring(0, i + 1);
                String part2 = greater.substring(i + 1);
                return part1 + sort(part2);
            }
        }

        return "no answer"; //TODO Fix this/
    }

    private static String sort(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
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
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);
            System.out.println(result);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
