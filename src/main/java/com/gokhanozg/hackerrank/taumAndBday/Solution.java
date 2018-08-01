package com.gokhanozg.hackerrank.taumAndBday;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
        long b_ = b;
        long w_ = w;
        long bc_ = bc;
        long wc_ = wc;
        long z_ = z;
        if (bc_ + z_ < wc_) {
            return ((w_ * z_) + ((w_ + b_) * bc_));
        } else if (wc_ + z_ < bc_) {
            return ((b_ * z_) + ((w_ + b_) * wc_));
        } else {
            return ((w_ * wc_) + (b_ * bc_));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");

            int b = Integer.parseInt(bw[0]);

            int w = Integer.parseInt(bw[1]);

            String[] bcWcz = scanner.nextLine().split(" ");

            int bc = Integer.parseInt(bcWcz[0]);

            int wc = Integer.parseInt(bcWcz[1]);

            int z = Integer.parseInt(bcWcz[2]);

            long result = taumBday(b, w, bc, wc, z);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
