package com.gokhanozg.hackerrank.fraudulentActivityNotifications;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gokhan Ozgozen on 13-Jun-19.
 */
public class Solution2 {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        if (expenditure.length <= d) {
            return 0;
        }
        AtomicInteger count = new AtomicInteger(0);

        for (int i = 0; i < expenditure.length - d; i++) {
            int val = expenditure[i + d];
            int[] prev = new int[d];
            for (int j = 0; j < d; j++) {
                prev[j] = expenditure[i + j];
            }
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    Arrays.sort(prev);
                    float median;
                    if (prev.length % 2 == 0) {
                        median = (prev[prev.length / 2] + prev[(prev.length / 2) - 1]) / 2f;
                    } else {
                        median = prev[prev.length / 2];
                    }
                    if (val >= (median * 2)) {
                        count.incrementAndGet();
                    }
                }
            });
        }
        try {
            executorService.shutdown();
            executorService.awaitTermination(99999, TimeUnit.DAYS);
        } catch (Throwable t) {
            throw new IllegalStateException("Problem!");
        }
        return count.get();
    }


    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] expenditure = new int[n];
//
//        String[] expenditureItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int expenditureItem = Integer.parseInt(expenditureItems[i]);
//            expenditure[i] = expenditureItem;
//        }
//
//        int result = activityNotifications(expenditure, d);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();


//
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10, 20, 30, 40, 50, 9, 8, 7, 6}, 5)));
//        System.err.println(String.format("Expected =%s , got =%s",1,activityNotifications(new int[]{10, 20, 30, 40, 50}, 3)));
//        System.err.println(String.format("Expected =%s , got =%s",2,activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5)));
//        System.err.println(String.format("Expected =%s , got =%s",3,activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5,45}, 5)));
        System.err.println(String.format("Expected =%s , got =%s", 3, activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5, 45}, 5)));
//        System.err.println(String.format("Expected =%s , got =%s",3,activityNotifications(new int[]{1,2,3,4,4}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,4,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,10,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,11,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,20,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,21,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,30,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,31,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,40,5}, 4)));
//        System.err.println(String.format("Expected =%s , got =%s",0,activityNotifications(new int[]{10,20,30,40,41,5}, 4)));
    }
}
