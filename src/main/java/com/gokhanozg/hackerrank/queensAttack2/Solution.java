package com.gokhanozg.hackerrank.queensAttack2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int count = 0;
        //construct obstacles
        Set<String> obsSet = new HashSet<>();
        if (obstacles != null && obstacles.length > 0) {
            for (int i = 0; i < obstacles.length; i++) {
                obsSet.add("" + obstacles[i][0] + "_" + obstacles[i][1]);
            }
        }

        //up
        for (int i = r_q + 1; i <= n; i++) {
            if (obsSet.contains("" + i + "_" + c_q)) {
                break;
            }
            count++;
        }
        //down
        for (int i = r_q - 1; i >= 1; i--) {
            if (obsSet.contains("" + i + "_" + c_q)) {
                break;
            }
            count++;
        }
        //left
        for (int i = c_q - 1; i >= 1; i--) {
            if (obsSet.contains("" + r_q + "_" + i))
                break;
            count++;
        }
        //right
        for (int i = c_q + 1; i <= n; i++) {
            if (obsSet.contains("" + r_q + "_" + i))
                break;
            count++;
        }
        //rightUp
        for (int i = r_q + 1, j = c_q + 1; i <= n && j <= n; i++, j++) {
            if (obsSet.contains("" + i + "_" + j))
                break;
            count++;
        }
        //rightDown
        for (int i = r_q - 1, j = c_q + 1; i >= 1 && j <= n; i--, j++) {
            if (obsSet.contains("" + i + "_" + j))
                break;
            count++;
        }
        //leftUp
        for (int i = r_q + 1, j = c_q - 1; i <= n && j >= 1; i++, j--) {
            if (obsSet.contains("" + i + "_" + j))
                break;
            count++;
        }
        //leftDown
        for (int i = r_q - 1, j = c_q - 1; i >= 1 && j >= 1; i--, j--) {
            if (obsSet.contains("" + i + "_" + j))
                break;
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
