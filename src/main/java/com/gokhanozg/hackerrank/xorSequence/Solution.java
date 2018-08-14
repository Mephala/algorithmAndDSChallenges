package com.gokhanozg.hackerrank.xorSequence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the xorSequence function below.
    static long xorSequence(long l, long r) {
        long r1 = seqSum(r);
        long ret = 0L;
        List<Long> seqs = new ArrayList<>();
        for (long i = l; i <= r; i++) {
            ret ^= xorSeq(i);
            seqs.add(ret);
        }
        return r1;
    }

    static long xorSeq(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 3;
        } else {
            int m = (int) (n % 4);
            if (m == 3) {
                return 0;
            } else if (m == 2) {
                return n + 1;
            } else if (m == 1) {
                return 1;
            } else {
                return n;
            }
        }
    }

    static long seqSum(long r) {
        long v = r + 1;
        if (v == 0) {
            return 0;
        } else if (v == 1) {
            return 1;
        } else if (v == 2) {
            return 2;
        } else if (v == 3) {
            return 2;
        } else if (v == 4) {
            return 6;
        } else if (v == 5) {
            return 7;
        } else {
            int m = (int) (v % 8);
            if (m == 6) {
                return 0;
            } else if (m == 7) {
                return 0;
            } else if (m == 0) {
                return v;
            } else if (m == 1) {
                return v;
            } else if (m == 2) {
                return 2;
            } else if (m == 3) {
                return 2;
            } else if (m == 4) {
                return v + 2;
            } else {
                return v + 2;
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] lr = scanner.nextLine().split(" ");

            long l = Long.parseLong(lr[0]);

            long r = Long.parseLong(lr[1]);

            long result = xorSequence(l, r);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
