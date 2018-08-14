package com.gokhanozg.hackerrank.bigSorting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    // Complete the bigSorting function below.
//    static String[] bigSorting(String[] unsorted) {
//        Arrays.sort(unsorted, (o1, o2) -> {
//            if (o1.length() == o2.length()) {
//                for (int i = 0; i <o1.length() ; i++) {
//                    char c1 = o1.charAt(i);
//                    char c2 = o2.charAt(i);
//                    if(c1 != c2){
//                        return c1 - c2;
//                    }
//                }
//                return 0;
//            }
//            return o1.length() - o2.length();
//        });
//        return unsorted;
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];
//        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() == o2.length()) {
//                    for (int i = 0; i < o1.length(); i++) {
//                        char c1 = o1.charAt(i);
//                        char c2 = o2.charAt(i);
//                        if (c1 != c2) {
//                            return c1 - c2;
//                        }
//                    }
//                    return 0;
//                }
//                return o1.length() - o2.length();
//            }
//        });

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.next();
            unsorted[i] = unsortedItem;
//            pq.add(unsortedItem);
        }
//        for (int i = 0; i < n; i++) {
////            unsorted[i] = pq.poll();
////        }
        Arrays.sort(unsorted, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                for (int i = 0; i < o1.length(); i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
                return 0;
            }
            return o1.length() - o2.length();
        });

//        String[] result = bigSorting(unsorted);
        String[] result = unsorted;

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
