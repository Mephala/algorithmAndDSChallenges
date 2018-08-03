package com.gokhanozg.hackerrank.fairRations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int bread = 0;
        boolean must = false;
        for (int i = 0; i < B.length; i++) {
            if (must) {
                B[i]++;
                bread++;
                must = false;
            }
            if (B[i] % 2 == 1) {
                bread++;
                B[i]++;
                must = true;
            }
        }
        if (!must)
            return bread;
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        if (result == -1) {
            bufferedWriter.write("NO");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
