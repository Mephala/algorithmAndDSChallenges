package com.gokhanozg.fund.euclid;

/**
 * Created by Mephalay on 13-Jul-18.
 */
public class TestImp {

    public static void main(String[] args) {
        System.out.println(gcd(24, 36));
        System.out.println(gcd(36, 24));
        System.out.println(lcm(36, 24));
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }


}
