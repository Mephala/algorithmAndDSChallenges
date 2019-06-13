package com.gokhanozg.hackerrank.fraudulentActivityNotifications;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        if (expenditure.length <= d) {
            return 0;
        }
        List<Integer> observedPayments = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            observedPayments.add(expenditure[i]);
        }
        Collections.sort(observedPayments);

        int m1 = observedPayments.get(observedPayments.size() / 2);
        int m2 = observedPayments.size() % 2 == 1 ? m1 : observedPayments.get(observedPayments.size() / 2 - 1);

        int count = 0;
        for (int i = d; i < expenditure.length; i++) {
            Integer next = expenditure[i];
            float median = (m1 + m2) / 2f;
            if (next >= median * 2) {
                count++;
            }

            if (i == expenditure.length - 1) {
                continue;
            }

            observedPayments.remove(Integer.valueOf(expenditure[i - d]));

            int begin = 0;
            int end = observedPayments.size() - 1;
            int insertIndex = -1;

            while (begin <= end) {
                int mid = (begin + end) / 2;

                int midVal = observedPayments.get(mid);

                if (midVal == next) {
                    insertIndex = mid;
                    break;
                } else if (midVal < next) {
                    if (mid == observedPayments.size() - 1) {
                        insertIndex = -2; // add tail
                        break;
                    } else if (observedPayments.get(mid + 1) > next) {
                        insertIndex = mid + 1;
                        break;
                    } else {
                        begin = mid + 1;
                    }
                } else {
                    if (mid == 0) {
                        insertIndex = 0; // insert head
                        break;
                    } else if (observedPayments.get(mid - 1) < next) {
                        insertIndex = mid - 1;
                        break;
                    } else {
                        end = mid - 1;
                    }
                }

            }

            if (insertIndex == -1) {
                throw new IllegalStateException("Should never happen!");
            } else if (insertIndex == -2) {
                observedPayments.add(next);
            } else {
                observedPayments.add(insertIndex, next);
            }

            m1 = observedPayments.get(observedPayments.size() / 2);
            m2 = observedPayments.size() % 2 == 1 ? m1 : observedPayments.get(observedPayments.size() / 2 - 1);

        }

        return count;
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
//        System.err.println(String.format("Expected =%s , got =%s",3,activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5,45}, 5)));
//        System.err.println(String.format("Expected =%s , got =%s",3,activityNotifications(new int[]{1,2,3,4,4}, 4)));
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
