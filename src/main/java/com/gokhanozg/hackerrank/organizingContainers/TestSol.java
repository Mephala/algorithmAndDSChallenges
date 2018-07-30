package com.gokhanozg.hackerrank.organizingContainers;

/**
 * Created by Gokhan Ozgozen on 30-Jul-18.
 */
public class TestSol {

    public static void main(String[] args) {
        System.out.println("Possible," + Solution.organizingContainers(new int[][]{{1, 1}, {1, 1}}));
        System.out.println("Impossible," + Solution.organizingContainers(new int[][]{{0, 2}, {1, 1}}));
        System.out.println("Possible," + Solution.organizingContainers(new int[][]{{0, 4, 0}, {2, 0, 2}, {2, 0, 0}}));
        System.out.println("Possible," + Solution.organizingContainers(new int[][]{{0, 4, 0}, {2, 0, 2}, {2, 0, 0}}));
        System.out.println("Possible," + Solution.organizingContainers(new int[][]{{0, 0, 2, 1}, {0, 0, 2, 0}, {0, 2, 0, 2}, {3, 0, 0, 0}}));
        System.out.println("Possible," + Solution.organizingContainers(new int[][]{{997612619, 934920795, 998879231, 999926463}, {960369681, 997828120, 999792735, 979622676}, {999013654, 998634077, 997988323, 958769423}, {997409523, 999301350, 940952923, 993020546}}));
//        int[] a = new int[]{997612619, 934920795, 998879231, 999926463, 960369681, 997828120, 999792735, 979622676, 999013654, 998634077, 997988323, 958769423, 997409523, 999301350, 940952923, 993020546};
//        int min = Integer.MAX_VALUE;
//        for (int i : a) {
//            min = Math.min(min, i);
//        }
//        int[] b = new int[a.length];
//        for (int i = 0; i < a.length; i++) {
//            b[i] = a[i] - min;
//        }
//        for (int i : b) {
//            System.out.println(i);
//        }
    }
}
