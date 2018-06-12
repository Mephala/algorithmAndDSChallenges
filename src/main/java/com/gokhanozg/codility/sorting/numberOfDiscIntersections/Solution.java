package com.gokhanozg.codility.sorting.numberOfDiscIntersections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {

    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Disk> diskList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            diskList.add(new Disk(i, A[i]));
        }
        Collections.sort(diskList, new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                return Long.valueOf(o1.rightmost).compareTo(o2.rightmost);
            }
        });
        long totalIntersection = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            Disk rightMostDisk = diskList.get(i);
            totalIntersection = totalIntersection + findIntersections(rightMostDisk, i, diskList);
            if (totalIntersection > 1E7) {
                return -1;
            }
        }
        return (int) totalIntersection;

    }

    private long findIntersections(Disk rightMostDisk, int i, List<Disk> diskList) {
        long farthestIntersectPoint = rightMostDisk.leftmost;
        int jumpSize = i / 2;
        if (jumpSize == 0)
            jumpSize = 1;
        int searchIndex = i - jumpSize;
        int leftMostIndex = i;
        while (true) {
            jumpSize = jumpSize / 2;
            if (jumpSize == 0)
                jumpSize = 1;
            if (searchIndex == 0) {
                leftMostIndex = 0;
                break;
            }
            if (searchIndex == i) {
                leftMostIndex = i;
                break;
            }
            Disk d = diskList.get(searchIndex);
            if (d.rightmost >= farthestIntersectPoint) {
                //keep going left.
                leftMostIndex = searchIndex;
                searchIndex -= jumpSize;
            } else {
                //keep going right.
                searchIndex += jumpSize;
                if (searchIndex == leftMostIndex) {
                    //found limit point
                    break;
                }
            }
        }
        return i - leftMostIndex;
    }

    class Disk {
        long rightmost;
        long leftmost;

        Disk(int origin, int r) {
            this.rightmost = origin + r;
            this.leftmost = origin - r;
            if (leftmost < 0) {
                leftmost = 0; // no need to calculate negative zones, no disk originates at negative zone.
            }
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "rightmost=" + rightmost +
                    ", leftmost=" + leftmost +
                    '}';
        }
    }
}