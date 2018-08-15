package com.gokhanozg.hackerrank.marsExploration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        char[] sos = new char[]{'S', 'O', 'S'};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos[i % 3])
                count++;
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
