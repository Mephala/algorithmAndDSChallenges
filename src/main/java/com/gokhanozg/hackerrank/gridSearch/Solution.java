package com.gokhanozg.hackerrank.gridSearch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int plen = P.length;
        int searchEnd = G.length - plen;
        String start = P[0];
        //FIXME add multiple checks for repetitive occurences
        for (int i = 0; i <= searchEnd; i++) {
            String sline = G[i];
            List<Integer> sindexList = new ArrayList<>();
            int end = sline.length() - start.length();
            for (int j = 0; j <= end; j++) {
                String part = sline.substring(j, j + start.length());
                if (part.equals(start))
                    sindexList.add(j);
            }
            for (Integer sIndex : sindexList) {
                boolean match = true;
                for (int j = 1; j < P.length; j++) {
                    String Gline = G[i + j];
                    String Pline = P[j];
                    if (!Gline.substring(sIndex, sIndex + start.length()).equals(Pline)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return "YES";
                }
            }

        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
