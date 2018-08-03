package com.gokhanozg.hackerrank.manasaAndStones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        Set<Integer> r = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            int bc = (n - 1) - i;
            int val = (i * a) + (bc * b);
            r.add(val);
        }
        List<Integer> sorted = new ArrayList<>(r);
        Collections.sort(sorted);
        return sorted.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
