package com.gokhanozg.hackerrank.betweenTwoSets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the getTotalX function below.
     */
    static int getTotalX(int[] a, int[] b) {

        int max = Integer.MAX_VALUE;
        for (int i : b) {
            max = Math.min(max, i);
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            min = (int) lcm(min, a[i]);
        }
        List<Integer> lcmlist = new ArrayList<>();
        int i = 1;
        int minCand = min * i;
        while (minCand <= max) {
            lcmlist.add(minCand);
            i++;
            minCand = min * i;
        }
        int count = 0;
        for (Integer lcm : lcmlist) {
            boolean alldivisible = true;
            for (int bv : b) {
                if (bv % lcm != 0) {
                    alldivisible = false;
                }
            }
            if (alldivisible)
                count++;
        }
        return count;
    }

    private static long gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    private static long lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
