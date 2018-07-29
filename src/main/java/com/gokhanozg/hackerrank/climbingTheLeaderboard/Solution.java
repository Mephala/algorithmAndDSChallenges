package com.gokhanozg.hackerrank.climbingTheLeaderboard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        Map<Integer, Integer> scoreRankMap = new HashMap<>();
        int rank = 1;
        List<Integer> scoresList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (!scoreRankMap.containsKey(scores[i])) {
                scoreRankMap.put(scores[i], rank);
                scoresList.add(scores[i]);
                rank++;
            }
        }
        int[] aliceRanks = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            int aliceRank = getRank(alice[i], scoresList, scoreRankMap);
            scoreRankMap.put(alice[i], aliceRank);
            aliceRanks[i] = aliceRank;
        }
        return aliceRanks;
    }

    static int getRank(int x, List<Integer> scoresList, Map<Integer, Integer> scoreRankMap) {
        int len = scoresList.size();
        int begin = 0;
        int end = len - 1;
        int low = -1;
        int lowIndex = -1;
        int high = -1;
        int highIndex = -1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (scoresList.get(mid) > x) {
                begin = mid + 1;
                high = scoresList.get(mid);
                highIndex = mid;
            } else if (scoresList.get(mid) == x) {
                scoresList.add(mid, x);
                return scoreRankMap.get(x);
            } else {
                end = mid - 1;
                low = scoresList.get(mid);
                lowIndex = mid;
            }
        }
        if (low == -1 && high == -1) {
            System.err.println("Bug!");
        }
        int rank;
        if (low != -1 && high != -1) {
            if (low == high) {
                System.err.println("Bug2");
            }
            rank = scoreRankMap.get(low);
            updateRanks(scoreRankMap, lowIndex, scoresList);
            scoresList.add(lowIndex, x);
        } else if (low == -1) {
            // We have the worst rank.
            rank = scoreRankMap.size() + 1;
            scoresList.add(x);
            //no need to update ranks.
        } else {
            // We have the best score.
            rank = 1;
            updateRanks(scoreRankMap, 0, scoresList);
            scoresList.add(0, x);
        }
        return rank;

    }

    private static void updateRanks(Map<Integer, Integer> scoreRankMap, int lowIndex, List<Integer> scoreList) {
        for (int i = lowIndex; i < scoreList.size(); i++) {
            scoreRankMap.put(scoreList.get(i), scoreRankMap.get(scoreList.get(i)) + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
