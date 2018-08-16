package com.gokhanozg.codeWars.commonDenominators;

public class Fracts {
    // your code
    public static String convertFrac(long[][] lst) {
        if (lst.length == 0) {
            return "";
        } else if (lst.length == 1) {
            return "(" + lst[0][0] + "," + lst[0][1] + ")";
        } else if (lst.length == 2) {
            long a = lst[0][1];
            long b = lst[1][1];
            long lcm = lcm(a, b);
            return stringify(lst, lcm);
        } else {
            long a = lst[0][1];
            long b = lst[1][1];
            long lcm = lcm(a, b);
            for (int i = 2; i < lst.length; i++) {
                lcm = lcm(lcm, lst[i][1]);
            }
            return stringify(lst, lcm);
        }
    }

    static String stringify(long[][] lst, long denom) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lst.length; i++) {
            long nom = lst[i][0];
            long den = lst[i][1];
            sb.append("(");
            sb.append(nom * denom / den).append(",").append(denom).append(")");
        }
        return sb.toString();
    }

    static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

}