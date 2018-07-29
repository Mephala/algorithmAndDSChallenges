package com.gokhanozg.hackerrank.gradingStudents;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scan = new Scanner(System.in);

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        int[] round = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 38) {
                round[i] = grades[i];
            } else {
                int mod = grades[i] % 5;
                if (mod >= 3) {
                    round[i] = grades[i] + 5 - mod;
                } else {
                    round[i] = grades[i];
                }
            }
        }
        return round;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}
