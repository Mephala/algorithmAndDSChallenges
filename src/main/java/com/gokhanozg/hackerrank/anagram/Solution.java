package com.gokhanozg.hackerrank.anagram;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the anagram function below.
    static int anagram(String s) {
//        Map<Character, Integer> occurence = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            occurence.put(c, occurence.getOrDefault(c, 0) + 1);
//        }
//        int count = 0;
//        for (Integer value : occurence.values()) {
//            if(value%2 == 1){
//                count++;
//            }
//        }
//        return count/2;
        if (s.length() % 2 == 1)
            return -1;
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        Map<Character, Integer> s1Occurences = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Occurences.put(c, s1Occurences.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> s2Occurences = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            s2Occurences.put(c, s2Occurences.getOrDefault(c, 0) + 1);
        }
        int sameCount = 0;
        for (Map.Entry<Character, Integer> s1Occurence : s1Occurences.entrySet()) {
            char c = s1Occurence.getKey();
            int count = s1Occurence.getValue();
            if (s2Occurences.containsKey(c)) {
                sameCount += Math.min(s2Occurences.get(c), count);
            }
        }
        return s1.length() - sameCount;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
