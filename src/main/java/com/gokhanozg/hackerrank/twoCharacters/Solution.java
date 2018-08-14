package com.gokhanozg.hackerrank.twoCharacters;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {


    // Complete the solve function below.
    static int solve(String s) {
        Set<Character> chars = new HashSet<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!chars.contains(c)) {
                characters.add(c);
                chars.add(c);
            }
        }
        if (characters.size() < 2) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < characters.size(); i++) {
            for (int j = i + 1; j < characters.size(); j++) {
                char c1 = characters.get(i);
                char c2 = characters.get(j);
                String tmp = s;
                for (Character character : characters) {
                    if (character != c1 && character != c2) {
                        tmp = tmp.replaceAll(character.toString(), "");
                    }
                }
                String invalid1 = "" + c1 + c1;
                String invalid2 = "" + c2 + c2;
                if (!tmp.contains(invalid1) && !tmp.contains(invalid2)) {
                    max = Math.max(max, tmp.length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = solve(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
