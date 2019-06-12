package com.gokhanozg.hackerrank.fraudulentActivityNotifications;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        if (expenditure.length <= d) {
            return 0;
        }
        int[] sortedInitialExpenditure = new int[d];
        System.arraycopy(expenditure, 0, sortedInitialExpenditure, 0, d);
        Arrays.sort(sortedInitialExpenditure);

        int[] currentExpenditureRecords = sortedInitialExpenditure;

        int count = 0;
        for (int i = d; i < expenditure.length; i++) {
            float next = expenditure[i];
            float median = calcMedian(currentExpenditureRecords);
            if (next >= (median * 2)) {
                count++;
            }
            addTrailingRecord(currentExpenditureRecords, expenditure[i]);
        }

        return count;
    }

    private static void addTrailingRecord(int[] currentExpenditureRecords, int i) {
        if (currentExpenditureRecords.length == 1) {
            currentExpenditureRecords[0] = i;
        } else {
            int[] firstRemovedArray = new int[currentExpenditureRecords.length - 1];
            System.arraycopy(currentExpenditureRecords, 1, firstRemovedArray, 0, firstRemovedArray.length);

            int insertIndex = calculateInsertIndex(firstRemovedArray, i);

            if (insertIndex == 0) {
                currentExpenditureRecords[0] = i;
            } else if (insertIndex == currentExpenditureRecords.length - 1) {
                int[] tmp = new int[currentExpenditureRecords.length];
                System.arraycopy(currentExpenditureRecords, 1, tmp, 0, currentExpenditureRecords.length - 1);
                tmp[currentExpenditureRecords.length - 1] = i;
                System.arraycopy(tmp, 0, currentExpenditureRecords, 0, tmp.length);
            } else {
                int[] pre = new int[insertIndex];
                int[] post = new int[firstRemovedArray.length - insertIndex];
                System.arraycopy(firstRemovedArray, 0, pre, 0, insertIndex);
                System.arraycopy(firstRemovedArray, insertIndex, post, 0, firstRemovedArray.length - insertIndex);
                System.arraycopy(pre, 0, currentExpenditureRecords, 0, pre.length);
                currentExpenditureRecords[insertIndex] = i;
                System.arraycopy(post, 0, currentExpenditureRecords, insertIndex + 1, post.length);

            }
        }
    }

    private static int calculateInsertIndex(int[] firstRemovedArray, int i) {
        int begin = 0;
        int end = firstRemovedArray.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (firstRemovedArray[mid] == i) {
                return mid;
            } else if (firstRemovedArray[mid] < i) {
                if (mid == firstRemovedArray.length - 1) {
                    return firstRemovedArray.length;
                } else if (firstRemovedArray[mid + 1] > i) {
                    return mid + 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (mid == 0) {
                    return 0;
                } else if (firstRemovedArray[mid - 1] < i) {
                    return mid - 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    private static float calcMedian(int[] currentExpenditureRecords) {
        if (currentExpenditureRecords.length % 2 == 1) {
            return currentExpenditureRecords[currentExpenditureRecords.length / 2];
        }
        return (currentExpenditureRecords[currentExpenditureRecords.length / 2] + currentExpenditureRecords[(currentExpenditureRecords.length / 2) - 1]) / 2f;
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
        System.out.println(activityNotifications(new int[]{10, 20, 30, 40, 50}, 3));
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4));
    }
}
