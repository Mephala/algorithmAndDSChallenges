package com.gokhanozg.hackerrank.viralAdvertising;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        return findViral(5, n);
    }

    private static int findViral(int i, int n) {
        if (n == 0)
            return 0;
        return i / 2 + findViral((i / 2) * 3, n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
