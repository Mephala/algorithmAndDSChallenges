package com.gokhanozg.hackerrank.drawingBook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        int lastPageDif = n - 1;
        int finalFlip;
        if (lastPageDif % 2 == 0) {
            finalFlip = lastPageDif / 2;
        } else {
            finalFlip = (lastPageDif + 1) / 2;
        }
        int pdif = p - 1;
        int pFlip;
        if (pdif % 2 == 0) {
            pFlip = pdif / 2;
        } else {
            pFlip = (pdif + 1) / 2;
        }
        int reversePFlip = finalFlip - pFlip;
        return Math.min(reversePFlip, pFlip);

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
