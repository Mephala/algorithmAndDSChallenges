package com.gokhanozg.hackerrank.beautifulDaysAtTheMovies;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        for (int l = i; l <= j; l++) {
            long reverse = reverseVal(l);
            if (Math.abs(reverse - l) % k == 0)
                count++;
        }
        return count;

    }

    private static long reverseVal(int i) {
        String val = Integer.valueOf(i).toString();
        StringBuilder sb = new StringBuilder();
        for (int j = val.length() - 1; j >= 0; j--) {
            sb.append(val.charAt(j));
        }
        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
