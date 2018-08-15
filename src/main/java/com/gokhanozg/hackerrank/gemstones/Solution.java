package com.gokhanozg.hackerrank.gemstones;

import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        if (arr.length == 1) {
            return arr[0].length();
        }
        List<Set<Character>> charSetList = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        String minStr = "";
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            Set<Character> set = new HashSet<>();
            for (int k = 0; k < s.length(); k++) {
                set.add(s.charAt(k));
            }
            charSetList.add(set);
            if (s.length() < min) {
                min = s.length();
                minStr = s;
                minIndex = i;
            }
        }
        int count = 0;
        Set<Character> minSet = charSetList.get(minIndex);
        for (Character character : minSet) {
            boolean foundAll = true;
            for (int j = 0; j < charSetList.size(); j++) {
                if (j != minIndex) {
                    Set<Character> characters = charSetList.get(j);
                    if (!characters.contains(character)) {
                        foundAll = false;
                        break;
                    }
                }
            }
            if (foundAll)
                count++;
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
