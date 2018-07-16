package com.gokhanozg.codeWars.getTheMiddleCharacter;

class Kata {
    public static String getMiddle(String word) {
        int len = word.length();
        if (len == 2) {
            return word;
        }
        if (word.length() % 2 == 0) {
            return word.substring((len / 2) - 1, (len / 2) - 1 + 2);
        } else {
            return word.substring(((len + 1) / 2) - 1, ((len + 1) / 2) - 1 + 1);
        }
    }
}