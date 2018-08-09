package com.gokhanozg.hackerrank.bombermanGame;

/**
 * Created by Gokhan Ozgozen on 08-Aug-18.
 */
public class TestSol {

    public static void main(String[] args) {
//        printStrArr(Solution.bomberMan(3, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."}));
//        printStrArr(Solution.bomberMan(1, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."}));
//        printStrArr(Solution.bomberMan(2, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."}));
//        printStrArr(Solution.bomberMan(4, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."}));
//        printStrArr(Solution.bomberMan(5, new String[]{".......", "...O...", "....O..", ".......", "OO.....", "OO....."}));
//        printStrArr(Solution.bomberMan(669782675, new String[]{"O.OO...OO.....OOO...OO.O........O.....OO....O..OOO.O......O......OOOO......OOOO.O...O..O.O..O................O..O.....OO..OO.O....OO..O.....OOO....OOOO.O.....O.O.......O.O...O.OOO........O..OO...OO"}));
//        printStrArr(Solution.bomberMan(669782673, new String[]{"O.OO...OO.....OOO...OO.O........O.....OO....O..OOO.O......O......OOOO......OOOO.O...O..O.O..O................O..O.....OO..OO.O....OO..O.....OOO....OOOO.O.....O.O.......O.O...O.OOO........O..OO...OO"}));
        printStrArr(Solution.bomberMan(3, new String[]{"0", ".", "0", ".", "0", ".", "."}));
        printStrArr(Solution.bomberMan(4, new String[]{"0", ".", "0", ".", "0", ".", "."}));
        printStrArr(Solution.bomberMan(5, new String[]{"0", ".", "0", ".", "0", ".", "."}));
//        printStrArr(Solution.bomberMan(5, new String[]{"0",".","0",".","0",".","."}));

        // Test on case 15!
    }

    static void printStrArr(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("***********");
    }
}
