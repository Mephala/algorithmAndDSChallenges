package com.gokhanozg.codeWars.writeValuesInExpandedForm;

public class Kata {
    public static String expandedForm(int num) {
        int degree = ("" + num).length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            if (i == 0 && num != 0) {
                sb.append(num);
            } else {
                int val = (int) (num / Math.pow(10, i));
                if (val != 0) {
                    sb.append(val).append(("" + (int) Math.pow(10, i)).substring(1)).append(" + ");
                    num -= val * Math.pow(10, i);
                }
            }

        }
        if (num == 0) {
            String s = sb.toString();
            return s.substring(0, s.length() - 3);
        }
        return sb.toString();

    }
}