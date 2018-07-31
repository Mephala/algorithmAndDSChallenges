package com.gokhanozg.hackerrank.sherlockAndSquares;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the squares function below.
    static int squares(int a, int b) {
        double as = Math.sqrt(a);
        double bs = Math.sqrt(b);
        int start = BigDecimal.valueOf(as).setScale(0, BigDecimal.ROUND_UP).intValue();
        int end = BigDecimal.valueOf(bs).setScale(0, RoundingMode.DOWN).intValue();
        return end - start + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
