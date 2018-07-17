package com.gokhanozg.codeWars.sortTheOdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kata {
    public static int[] sortArray(int[] array) {
        if (array == null || array.length == 0)
            return array;
        List<Integer> oddNumberIndices = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                oddNumberIndices.add(i);
                oddNumbers.add(array[i]);
            }
        }
        Collections.sort(oddNumbers);
        for (int i = 0; i < oddNumberIndices.size(); i++) {
            array[oddNumberIndices.get(i)] = oddNumbers.get(i);
        }
        return array;
    }
}