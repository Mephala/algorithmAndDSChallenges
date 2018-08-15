package com.gokhanozg.hackerrank.beautifulBinaryString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        List<Integer> uglyIndex = new ArrayList<>();
        for (int i = 0; i < b.length() - 2; i++) {
            String s = b.substring(i, i + 3);
            if (s.equals("010")) {
                uglyIndex.add(i);
            }
        }
        int count = 0;
        int[] indexes = uglyIndex.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < indexes.length; i++) {
            if (i == indexes.length - 1) {
                count++;
            } else {
                int cur = indexes[i];
                int next = indexes[i + 1];
                if (next == cur + 2) {
                    count++;
                    i++; // omit next;
                } else {
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
