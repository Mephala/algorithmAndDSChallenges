package com.gokhanozg.hackerrank.hackerrankInString;

import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        Map<Character, List<Integer>> charPos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charPos.containsKey(c)) {
                charPos.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                charPos.put(c, list);
            }
        }
        int index = -1;
        final String target = "hackerrank";
        int targetIndex = 0;
        while (index < s.length() && targetIndex < target.length()) {
            char search = target.charAt(targetIndex);
            List<Integer> availableIndexes = charPos.get(search);
            if (availableIndexes == null) {
                return "NO";
            }
            boolean found = false;
            for (Integer availableIndex : availableIndexes) {
                if (availableIndex > index) {
                    index = availableIndex;
                    targetIndex++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return "NO";
            }
        }
        return targetIndex == target.length() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);
            System.out.println(result);
            System.out.println();
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
