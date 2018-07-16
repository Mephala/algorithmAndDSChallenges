package com.gokhanozg.codeWars.findTheoddInt;

/**
 * Created by Mephalay on 17-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        int xor = 0;
        int[] arr1 = new int[]{1, 8, 5, 9, 3, 0, 0, 8, 9, 3, 1};
        for (int i : arr1) {
            xor ^= i;
        }
        System.out.println(xor);
    }
}
