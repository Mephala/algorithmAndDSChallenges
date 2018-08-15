package com.gokhanozg.hackerrank.makingAnagrams;

/**
 * Created by Gokhan Ozgozen on 16-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println(Solution.makingAnagrams("cde", "abc"));
        System.out.println(Solution.makingAnagrams("a", "b"));
        System.out.println(Solution.makingAnagrams("ac", "ba"));
        System.out.println(Solution.makingAnagrams("abc", "xxxabc"));
    }
}
