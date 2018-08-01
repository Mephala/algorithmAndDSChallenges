package com.gokhanozg.hackerrank.acmICPCTeam;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int max = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                String s1 = topic[i];
                String s2 = topic[j];
                int count = getCount(s1, s2);
                max = Math.max(max, count);
            }
        }
        int bestTeams = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                String s1 = topic[i];
                String s2 = topic[j];
                int count = getCount(s1, s2);
                if (count == max)
                    bestTeams++;
            }
        }
        return new int[]{max, bestTeams};

    }

    private static int getCount(String s1, String s2) {
        int count = 0;
        for (int k = 0; k < s1.length(); k++) {
            if (s1.charAt(k) == '1' || s2.charAt(k) == '1')
                count++;
        }
        return count;
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
