package com.gokhanozg.hackerrank.lisasWorkbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int page = 0;
        int specialCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int problems = arr[i];
            page++; // each chapter is a new page
            int chapterPage = problems / k;
            int additionalProblems = problems % k;
            for (int j = 0; j < chapterPage; j++) {
                int startP = (j * k) + 1;
                int endP = startP + k - 1;
                if (page >= startP && page <= endP) {
                    specialCount++;
                }
                page++;
            }
            page--;
            if (additionalProblems > 0) {
                page++;
                int startP = (chapterPage * k) + 1;
                int endP = startP + additionalProblems - 1;
                if (page >= startP && page <= endP) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
