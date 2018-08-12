package com.gokhanozg.codeWars.tortoiseRacing;

import java.math.BigDecimal;

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        if (v1 >= v2) {
            return new int[]{-1, -1, -1};
        }
        double distance = g;
        double dif = v2 - v1;
        long h = (long) (distance / dif);
        distance -= h * dif;
        dif = dif / 60d;
        ;
        long m = (long) (distance / dif);
        distance -= m * dif;
        dif = dif / 60d;
        double s = distance / dif;
        return new int[]{(int) h, (int) m, new BigDecimal(s).setScale(0, BigDecimal.ROUND_HALF_UP).intValue()};
    }
}