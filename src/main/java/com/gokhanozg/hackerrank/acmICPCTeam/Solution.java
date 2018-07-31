package com.gokhanozg.hackerrank.acmICPCTeam;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        long max = -1;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                String s1 = topic[i];
                String s2 = topic[j];
                long val = new BigInteger(s1, 2).longValue() | new BigInteger(s2, 2).longValue();
                max = Math.max(max, val);
            }
        }
        int count = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                String s1 = topic[i];
                String s2 = topic[j];
                long val = new BigInteger(s1, 2).longValue() | new BigInteger(s2, 2).longValue();
                if (val == max)
                    count++;
            }
        }
        return new int[]{new BigInteger(Long.valueOf(max).toString()).toString(2).replaceAll("0", "").length(), count};
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);
        System.out.println();

        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write("\n");
//            }
            System.out.println(result[i]);

        }

//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
