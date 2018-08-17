package com.gokhanozg.codility.passwordLength;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        int max = 0;
        String[] ps = S.split(" ");
        for (String p : ps) {
            if (isValid(p)) {
                max = Math.max(max, p.length());
            }
        }
        return max;
    }

    //
    private boolean isValid(String p) {
        final int min = '0';
        final int max = 'z';
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (!(c >= min && c <= max))
                return false;
        }
        return true;
    }
}