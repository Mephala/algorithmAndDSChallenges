package com.gokhanozg.hackerrank.emasSuperComputer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    // Complete the twoPluses function below.

    private static final Scanner scanner = new Scanner(System.in);

    static int twoPluses(String[] grid) {
        int[][] m = new int[grid.length][grid[0].length()];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = grid[i].charAt(j) == 'G' ? 1 : 0;
            }
        }
        int goodCount = 0;
        List<Point> goodPoints = new ArrayList<>();
        List<Point> plusCenters = new ArrayList<>();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i - 1 >= 0 && i + 1 < m.length && j + 1 < m[0].length && j - 1 >= 0) {
                    int left = m[i][j - 1];
                    int right = m[i][j + 1];
                    int bottom = m[i + 1][j];
                    int up = m[i - 1][j];
                    int centre = m[i][j];
                    if (left == 1 && right == 1 && bottom == 1 && up == 1 && centre == 1) {
                        plusCenters.add(new Point(i, j));
                    } else {
                        if (centre == 1) {
                            goodCount++;
                            goodPoints.add(new Point(i, j));
                        }
                    }
                }
            }
        }
        if (plusCenters.size() == 0 && goodCount >= 2) {
            return 1; // we have at least 2 good points with length of 1, returning 1.
        }
        if (plusCenters.size() == 0 && goodCount < 2) {
            return 0; // we don't have 2 good points, returning 0.
        }
        int maxPlusLen = 1;
        Point maxPlusCentre = plusCenters.get(0);
        for (Point plusCenter : plusCenters) {
            int maxLen = m.length / 2;
            int pointLen = 1;
            for (int i = 2; i <= maxLen; i++) {
                int centeri = plusCenter.i;
                int centerj = plusCenter.j;
                int left = centerj - i >= 0 && m[centeri][centerj - i] == 1 ? 1 : 0;
                int right = centerj + i < m[0].length && m[centeri][centerj + i] == 1 ? 1 : 0;
                int up = centeri - i >= 0 && m[centeri - i][centerj] == 1 ? 1 : 0;
                int bottom = centeri + i < m.length && m[centeri + i][centerj] == 1 ? 1 : 0;
                if (left == 1 && right == 1 && up == 1 && bottom == 1) {
                    pointLen = i;
                } else {
                    break;
                }
            }
            if (pointLen > maxPlusLen) {
                maxPlusCentre = plusCenter;
                maxPlusLen = pointLen;
            }
        }
        Plus largestPlus = new Plus(maxPlusLen, maxPlusCentre.i, maxPlusCentre.j);
        plusCenters.remove(maxPlusCentre);
        if (plusCenters.size() == 0) {
            //we have one big plus only. checking single good points.
            Iterator<Point> pointIterator = goodPoints.iterator();
            while (pointIterator.hasNext()) {
                Point next = pointIterator.next();
                if (largestPlus.containsPoint(next)) {
                    pointIterator.remove();
                }
            }
            if (goodPoints.size() > 0) {
                return largestPlus.size();
            } else {
                return 0; //second largest plus has 0 area.
            }
        }
        maxPlusLen = 1;
        maxPlusCentre = plusCenters.get(0);
        for (Point plusCenter : plusCenters) {
            int maxLen = m.length / 2;
            int pointLen = 1;
            for (int i = 2; i <= maxLen; i++) {
                int centeri = plusCenter.i;
                int centerj = plusCenter.j;
                int left = centerj - i >= 0 && m[centeri][centerj - i] == 1 && !largestPlus.containsPoint(centeri, centerj - i) ? 1 : 0;
                int right = centerj + i < m[0].length && m[centeri][centerj + i] == 1 && !largestPlus.containsPoint(centeri, centerj + i) ? 1 : 0;
                int up = centeri - i >= 0 && m[centeri - i][centerj] == 1 && !largestPlus.containsPoint(centeri - i, centerj) ? 1 : 0;
                int bottom = centeri + i < m.length && m[centeri + i][centerj] == 1 && !largestPlus.containsPoint(centeri + i, centerj) ? 1 : 0;
                if (left == 1 && right == 1 && up == 1 && bottom == 1) {
                    pointLen = i;
                } else {
                    break;
                }
            }
            if (pointLen > maxPlusLen) {
                maxPlusCentre = plusCenter;
                maxPlusLen = pointLen;
            }
        }
        Plus secondLargestPlus = new Plus(maxPlusLen, maxPlusCentre.i, maxPlusCentre.j);
        return largestPlus.size() * secondLargestPlus.size();
    }

    static class Plus {
        Set<Point> pointSet = new HashSet<>();
        int len;
        int i;
        int j;

        Plus(int len, int i, int j) {
            this.len = len;
            this.i = i;
            this.j = j;
            for (int k = i - len; k <= i + len; k++) {
                pointSet.add(new Point(k, j));
            }
            for (int k = j - len; k <= j + len; k++) {
                pointSet.add(new Point(i, k));
            }
        }

        boolean containsPoint(int ip, int jp) {
            return pointSet.contains(new Point(ip, jp));
        }

        boolean containsPoint(Point p) {
            return pointSet.contains(p);
        }

        @Override
        public String toString() {
            return "Plus{" +
                    "len=" + len +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }

        int size() {
            return (len * 4) + 1;
        }
    }

    static class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                    j == point.j;
        }

        @Override
        public int hashCode() {

            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }


}
