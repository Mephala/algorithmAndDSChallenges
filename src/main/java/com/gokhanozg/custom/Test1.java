package com.gokhanozg.custom;

import java.util.*;

/**
 * Created by Gokhan Ozgozen on 7/3/18.
 */
public class Test1 {

    private static final int len = 6;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> letters = new ArrayList<>();
        letters.add("m");
        letters.add("a");
        letters.add("g");
        letters.add("e");
        letters.add("n");
        letters.add("E");
        Map<String, List<String>> candidatesLettersMap = new HashMap<>();
        for (String letter : letters) {
            List<String> cp = new ArrayList<>(letters);
            cp.remove(letter);
            candidatesLettersMap.put(letter, cp);
        }
        fillCandidatesLettersMap(candidatesLettersMap);
        List<String> finalDomains = new ArrayList<>(candidatesLettersMap.keySet());
        Collections.sort(finalDomains);
        List<String> lowerLetters = new ArrayList<>();
        for (String finalDomain : finalDomains) {
            lowerLetters.add(finalDomain.toLowerCase());
        }
        for (String lowerLetter : lowerLetters) {
            System.out.println(lowerLetter);
        }

    }

    private static void fillCandidatesLettersMap(Map<String, List<String>> candidatesLettersMap) {
        Set<String> names = candidatesLettersMap.keySet();
        List<String> namesList = new ArrayList<>(names);
        for (String name : namesList) {
            if (name.length() != len) {
                List<String> remainingLetters = candidatesLettersMap.get(name);
                if (remainingLetters == null)
                    continue;
                candidatesLettersMap.remove(name);
                for (String remainingLetter : remainingLetters) {
                    String nextName = name + remainingLetter;
                    List<String> cpRemaining = new ArrayList<>(remainingLetters);
                    cpRemaining.remove(remainingLetter);
                    candidatesLettersMap.put(nextName, cpRemaining);
                    fillCandidatesLettersMap(candidatesLettersMap);
                }
            }
        }
    }
}
