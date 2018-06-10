package com.gokhanozg.hackerrank.greedy.beautifulPairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {
        int retval = 0;
        int N = A.length;
        List<Integer> nonPairedAIndices = new ArrayList<>();
        List<Integer> nonPairedBIndices = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nonPairedAIndices.add(i);
            nonPairedBIndices.add(i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i] == B[j]) {
                    if (nonPairedAIndices.contains(i) && nonPairedBIndices.contains(j)) {
                        nonPairedAIndices.remove(Integer.valueOf(i));
                        nonPairedBIndices.remove(Integer.valueOf(j));
                        retval++;
                    }
                }
            }
        }
        if (nonPairedAIndices.size() > 0 && nonPairedBIndices.size() > 0) {
            retval++;
        } else {
            retval--;
        }
        return retval;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
