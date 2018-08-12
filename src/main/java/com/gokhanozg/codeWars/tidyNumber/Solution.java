package com.gokhanozg.codeWars.tidyNumber;

import java.util.Arrays;

public class Solution {
    public static boolean tidyNumber(int number) {
        String s = Integer.valueOf(number).toString();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return s.equals(new String(chars));
    }
}