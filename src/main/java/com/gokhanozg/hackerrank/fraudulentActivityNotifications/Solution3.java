package com.gokhanozg.hackerrank.fraudulentActivityNotifications;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Gokhan Ozgozen on 18-Jun-19.
 */
public class Solution3 {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        if (expenditure.length <= d) {
            return 0;
        }


        int[] observedPaymentsCount = new int[201];

        for (int i = 0; i < d; i++) {
            observedPaymentsCount[expenditure[i]]++;
        }

        for (int i = 1; i < observedPaymentsCount.length; i++) {
            observedPaymentsCount[i] = observedPaymentsCount[i - 1] + observedPaymentsCount[i];
        }


        int count = 0;
        for (int i = d; i < expenditure.length; i++) {
            Integer next = expenditure[i];
            float median = calculateMedian(observedPaymentsCount, d);
            if (next >= median * 2) {
                count++;
            }

            if (i == expenditure.length - 1) {
                continue;
            }


            removeAndAddExpenditure(expenditure[i - d], next, observedPaymentsCount);

        }

        return count;
    }

    private static void removeAndAddExpenditure(int toRemove, Integer toAdd, int[] observedPaymentsCount) {
        for (int i = toRemove; i < observedPaymentsCount.length; i++) {
            observedPaymentsCount[i]--;
        }
        for (int i = toAdd; i < observedPaymentsCount.length; i++) {
            observedPaymentsCount[i]++;
        }

    }

    private static float calculateMedian(int[] observedPayments, int d) {
        if (d % 2 == 1) {
            int m = (d / 2) + 1;
            return findElementByPosition(m, observedPayments);
        } else {
            int m = (d / 2) + 1;
            int m2 = m - 1;
            float f = findElementByPosition(m, observedPayments);
            float f2 = findElementByPosition(m2, observedPayments);
            return (f + f2) / 2;
        }

    }

    private static float findElementByPosition(int m, int[] observedPayments) {
        for (int i = 0; i < observedPayments.length; i++) {
            if (observedPayments[i] == m) {
                return i;
            } else if (observedPayments[i] > m) {
                if (i == 0) {
                    return 0;
                } else {
                    if (observedPayments[i - 1] < m) {
                        return i;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return -1;
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
        System.err.println(String.format("Expected =%s , got =%s", 2, activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5)));
        System.err.println(String.format("Expected =%s , got =%s", 3, activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5, 45}, 5)));
        System.err.println(String.format("Expected =%s , got =%s", 3, activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5, 45}, 5)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{1, 2, 3, 4, 4}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 4, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 10, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 11, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 20, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 21, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 30, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 31, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 40, 5}, 4)));
        System.err.println(String.format("Expected =%s , got =%s", 0, activityNotifications(new int[]{10, 20, 30, 40, 41, 5}, 4)));
    }
}
