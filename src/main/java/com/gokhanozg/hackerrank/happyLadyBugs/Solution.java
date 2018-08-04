package com.gokhanozg.hackerrank.happyLadyBugs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        if ("_".equals(b)) {
            return "YES";
        }
        if (b.length() == 1)
            return "NO";
        if (!b.contains("_")) {
            char prev = b.charAt(0);
            boolean prevHappy = false;
            for (int i = 1; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c == prev) {
                    if (prevHappy) {
                        //do nothing
                    } else {
                        prevHappy = true;
                    }
                } else {
                    if (!prevHappy) {
                        return "NO";
                    } else {
                        prevHappy = false;
                        prev = c;
                    }
                }
            }
            if (prevHappy)
                return "YES";
            else
                return "NO";
        } else {
            Map<String, Integer> occurenceMap = new HashMap<>();
            for (int i = 0; i < b.length(); i++) {
                char c = b.charAt(i);
                if (c != '_') {
                    String s = Character.toString(c);
                    occurenceMap.put(s, occurenceMap.getOrDefault(s, 0) + 1);
                }
            }
            for (Integer occurence : occurenceMap.values()) {
                if (occurence == 1)
                    return "NO";
            }
            return "YES";
        }

    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);
//            System.out.println();
            System.out.println(result);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
