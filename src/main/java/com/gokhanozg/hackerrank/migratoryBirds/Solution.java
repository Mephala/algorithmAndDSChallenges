package com.gokhanozg.hackerrank.migratoryBirds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the migratoryBirds function below.

    private static final Scanner scanner = new Scanner(System.in);

    static int migratoryBirds(int[] ar) {
        PriorityQueue<Sight> pq = new PriorityQueue<>(new Comparator<Sight>() {
            @Override
            public int compare(Sight o1, Sight o2) {
                if (o1.count == o2.count) {
                    return Integer.compare(o1.id, o2.id);
                }
                return Integer.compare(o2.count, o1.count);
            }
        });
        Map<Integer, Integer> idSight = new HashMap<>();
        for (int id : ar) {
            idSight.put(id, idSight.getOrDefault(id, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> idSightE : idSight.entrySet()) {
            Sight s = new Sight();
            s.id = idSightE.getKey();
            s.count = idSightE.getValue();
            pq.add(s);
        }
        return pq.poll().id;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = migratoryBirds(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class Sight {
        int id;
        int count;
    }
}
