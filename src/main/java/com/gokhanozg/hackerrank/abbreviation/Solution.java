package com.gokhanozg.hackerrank.abbreviation;

import java.io.IOException;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);


    // Complete the abbreviation function below.
    //https://www.hackerrank.com/challenges/abbr/problem
//    static String abbreviation(String a, String b) {
//        return abbrCheck(a, b) ? "YES" : "NO";
//    }

    public static int hashCount = 0;
    static Stack<Strings> strings = new Stack<>();
    static Map<Long, String> cache = new HashMap<>();

    /**
     * Testing out other solutions.
     *
     * @param a
     * @param b
     * @return
     */
    static String abbreviationz(String a, String b) {
        boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
                if (ca >= 'A' && ca <= 'Z') {
                    if (ca == cb) dp[i][j] = dp[i - 1][j - 1];
                    else return "NO";
                } else {
                    ca = Character.toUpperCase(ca);
                    if (ca == cb) dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                    else dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[b.length()][a.length()] ? "YES" : "NO";
    }
//    static String abbreviationz(String a, String b) {
//        boolean[][] dp = new boolean[b.length() + 1][a.length() + 1];
//        for (int j = 0; j < dp[0].length; j++) dp[0][j] = true;
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//                char ca = a.charAt(j - 1), cb = b.charAt(i - 1);
//                if (ca >= 'A' && ca <= 'Z') {
//                    if (ca == cb) dp[i][j] = dp[i - 1][j - 1];
//                    else return "NO";
//                } else {
//                    ca = Character.toUpperCase(ca);
//                    if (ca == cb) dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
//                    else dp[i][j] = dp[i][j - 1];
//                }
//            }
//        }
//        return dp[b.length()][a.length()] ? "YES" : "NO";
//    }

    static long hash(String a, String b) {
        hashCount++;
        return 31 * a.length() * b.length();
    }

    static String abbreviation(String a, String b) {
        hashCount = 0;
        strings.clear();
        cache.clear();
        strings.push(new Strings(a, b));
        while (strings.size() != 0) {
            Strings s = strings.pop();
            if ("YES".equals(abbreviationR(s.a, s.b)))
                return "YES";
        }
        return "NO";
    }

    static String abbreviationR(String a, String b) {
        long hash = hash(a, b);
        if (cache.containsKey(hash)) {
            return cache.get(hash);
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            char bc = b.charAt(i);
            for (int j = a.length() - 1; j >= 0; j--) {
                char ac = a.charAt(j);
                if (Character.isUpperCase(ac)) {
                    if (ac == bc) {
                        b = b.substring(0, i);
                        a = a.substring(0, j);
                        return abbreviationR(a, b);
                    } else {
                        cache.put(hash, "NO");
                        return "NO";
                    }
                } else {
                    if (Character.toUpperCase(ac) == bc) {
                        strings.push(new Strings(a.substring(0, j), b.substring(0, i + 1)));
                        b = b.substring(0, i);
                        a = a.substring(0, j);
                        return abbreviationR(a, b);
                    }
                }
            }
        }
        if (b.length() != 0) {
            cache.put(hash, "NO");
            return "NO";
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (Character.isUpperCase(a.charAt(i))) {
                    cache.put(hash, "NO");
                    return "NO";
                }
            }
            cache.put(hash, "YES");
            return "YES";
        }

    }

    private static boolean abbrCheck(String a, String b) {

        if (a.length() == 0 && b.length() == 0)
            return true;
        for (int i = b.length() - 1; i >= 0; i--) {
            char bc = b.charAt(i);
            for (int j = a.length() - 1; j >= 0; j--) {
                char ac = a.charAt(j);
                if (Character.isLowerCase(ac)) {
                    //can remove or make upper case.
                    if (Character.toUpperCase(ac) == bc) {
                        // at this point we can either remove character or make it equal to b's char.
                        return abbrCheck(a.substring(0, j), b.substring(0, i)) || abbrCheck(a.substring(0, j), b.substring(0, i + 1));
                        // return (remove character from a but not b || remove character from both strings )
                    } else {
                        //remove char.
                        a = a.substring(0, j);
                    }
                } else {
                    if (ac != bc) {
                        return false;
                    } else {
                        a = a.substring(0, j);
                        b = b.substring(0, i);
                        break;
                    }
                }

            }

        }
        if (b.length() == 0 & a.length() > 0) {
            for (int i = 0; i < a.length(); i++) {
                if (Character.isUpperCase(a.charAt(i)))
                    return false;
            }
            return true;
        } else {
            return true;
        }
    }

    static class Strings {
        String a;
        String b;

        public Strings(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Strings)) return false;
            Strings strings = (Strings) o;
            return Objects.equals(a, strings.a) &&
                    Objects.equals(b, strings.b);
        }

        @Override
        public int hashCode() {

            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "Strings{" +
                    "a='" + a + '\'' +
                    ", b='" + b + '\'' +
                    '}';
        }
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
