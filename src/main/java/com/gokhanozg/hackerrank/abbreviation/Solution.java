package com.gokhanozg.hackerrank.abbreviation;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the abbreviation function below.
    //https://www.hackerrank.com/challenges/abbr/problem
    static String abbreviation(String a, String b) {
        return "yes";
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
