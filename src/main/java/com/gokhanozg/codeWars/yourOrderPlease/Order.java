package com.gokhanozg.codeWars.yourOrderPlease;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

public class Order {
    public static String order(String words) {
        String[] w = words.split(" ");
        Arrays.sort(w, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return findNum(o1).compareTo(findNum(o2));
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : w) {
            sb.append(s + " ");
        }
        return sb.toString().trim();
    }

    private static Integer findNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            try {
                BigDecimal b = new BigDecimal(Character.toString(c));
                return b.intValue();
            } catch (Throwable t) {
                continue;
            }
        }
        return -1;
    }

}