package com.gokhanozg.hackerrank.abbreviation;

import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the abbreviation function below.
    //https://www.hackerrank.com/challenges/abbr/problem
    static String abbreviation(String a, String b) {
        Map<Character, List<Integer>> alm = new HashMap<>();
        Map<Character, List<Integer>> aum = new HashMap<>();
        Map<Character, List<Integer>> bm = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if (Character.isUpperCase(c)) {
                List<Integer> indices = aum.get(c);
                if (indices == null) {
                    indices = new ArrayList<>();
                }
                indices.add(i);
                aum.put(c, indices);
            } else {
                List<Integer> indices = alm.get(c);
                if (indices == null) {
                    indices = new ArrayList<>();
                }
                indices.add(i);
                alm.put(c, indices);
            }

        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            List<Integer> indices = bm.get(c);
            if (indices == null) {
                indices = new ArrayList<>();
            }
            indices.add(i);
            bm.put(c, indices);
        }
        int highest = a.length();
        Map<Character, Integer> difMap = new HashMap<>();
        for (int i = b.length() - 1; i >= 0; i--) {
            char c = b.charAt(i);
            int bmLen = bm.get(c).size();
            if (aum.get(c) == null || alm.get(c) == null) {
                //doesn't contain this char
                return "NO";
            } else {
                int aumSize = aum.get(c) == null ? 0 : aum.get(c).size();
                if (aumSize > bmLen) {
                    return "NO";
                } else {
                    int dif = bmLen - aumSize; //we need to make this much of letters to uppercase
                    int almSize = alm.get(c) == null ? 0 : alm.get(c).size();
                    if (dif > almSize) {
                        return "NO";
                    }
                    difMap.put(c, dif);
                    if (dif > 0) {
                        highest = alm.get(c).get(alm.get(c).size() - 1); // highest point in which we can convert character into
                        difMap.put(c, dif - 1);
                    } else {
                        highest = aum.get(c).get(aum.get(c).size() - 1);
                    }
                }
            }
        }
        return "YEAH";
    }

    /**
     * Brute force
     *
     * @param args
     * @throws IOException
     */
//    static String abbreviation(String a, String b) {
//        int prevIndex = 0;
//        for (int i = 0; i < b.length(); i++) {
//            Character bc = b.charAt(i);
//            boolean found = false;
//            for (int j = prevIndex; j < a.length(); j++) {
//                Character ac = a.charAt(j);
//                if (Character.isUpperCase(ac) && !bc.equals(ac)) {
//                    return "NO";
//                } else if (Character.isLowerCase(ac) && Character.toUpperCase(ac) == bc) {
//                    if ("NO".equals(abbreviation(a.substring(j + 1), b.substring(i)))) {
//                        prevIndex = j + 1;
//                        found = true;
//                        break;
//                    } else {
//                        return "YES";
//                    }
//
//                } else if (Character.isLowerCase(bc) && Character.isUpperCase(ac)) {
//                    return "NO";
//                } else if (Character.isUpperCase(bc) && Character.toUpperCase(ac) == bc) {
//                    prevIndex = j + 1;
//                    found = true;
//                    break;
//                }
//            }
//            if (!found)
//                return "NO";
//        }
//        for (int i = prevIndex; i < a.length(); i++) {
//            if (Character.isUpperCase(a.charAt(i)))
//                return "NO";
//        }
//        return "YES";
//
//    }
    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);
            System.out.println(result);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }

//        bufferedWriter.close();

        scanner.close();
    }
}
