package com.gokhanozg.hackerrank.weightedUniformString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> weights = new HashSet<>();
        final int w = 96;
        char prev = s.charAt(0);
        weights.add(prev - w);
        int rep = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            weights.add(c - w);
            if (c == prev) {
                rep++;
                int weight = (c - w) * rep;
                weights.add(weight);
            } else {
                rep = 1;
                prev = c;
            }
        }

        String[] ret = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ret[i] = weights.contains(queries[i]) ? "Yes" : "No";
        }
        return ret;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
