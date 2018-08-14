package com.gokhanozg.hackerrank.greatXor;

/**
 * Created by Gokhan Ozgozen on 14-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
//        final long x = 10;
//        System.out.println(new BigInteger(Long.valueOf(x).toString()).toString(2));
//        for (int i = 1; i <x ; i++) {
//            if((i^x) > x){
//                System.out.println("i=" + i + " , " + new BigInteger(Long.valueOf(i).toString()).toString(2));
//            }
//        }
//        System.out.println("******");
//        System.out.println(Solution.theGreatXor(x));

        System.out.println(countBf(10) + " , " + Solution.theGreatXor(10));
        System.out.println(countBf(7) + " , " + Solution.theGreatXor(7));
        System.out.println(countBf(8) + " , " + Solution.theGreatXor(8));
        System.out.println(countBf(9) + " , " + Solution.theGreatXor(9));
        System.out.println(countBf(12) + " , " + Solution.theGreatXor(12));
        System.out.println(countBf(124821) + " , " + Solution.theGreatXor(124821));
        System.out.println(countBf(218428424) + " , " + Solution.theGreatXor(218428424));
    }

    private static long countBf(long x) {
        long count = 0L;
        for (int i = 1; i < x; i++) {
            if ((i ^ x) > x)
                count++;
        }
        return count;
    }
}
