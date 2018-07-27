package com.gokhanozg.hackerrank.saveThePrisoner;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
        long prisioner = n;
        long candy = m;
        long start = s;
        long inc = candy % prisioner;
        if (inc == 0) {
            long lastP = s - 1;
            if (lastP == 0) {
                lastP = n;
            }
            return (int) lastP;
        } else {
            long last = start + inc - 1;
            if (last > n) {
                return (int) (last % n);
            }
            return (int) last;
        }

    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nms = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nms[0]);

            int m = Integer.parseInt(nms[1]);

            int s = Integer.parseInt(nms[2]);

            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
