package com.gokhanozg.codility.stackAndQueue.stoneWall;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int totalBlocks = 0;

    public int solution(int[] H) {
        if (H == null || H.length == 0) {
            return 0;
        } else if (H.length == 1) {
            totalBlocks++;
        } else {
            int lowest = Integer.MAX_VALUE;
            for (int i = 0; i < H.length; i++) {
                if (H[i] < lowest) {
                    lowest = H[i];
                }
            }
            totalBlocks++;
            List<Integer> subBlock = new ArrayList<>();
            for (int i = 0; i < H.length; i++) {
                if (H[i] == lowest) {
                    int[] subArr = new int[subBlock.size()];
                    for (int j = 0; j < subBlock.size(); j++) {
                        subArr[j] = subBlock.get(j);
                    }
                    solution(subArr);
                    subBlock.clear();
                } else {
                    subBlock.add(H[i] - lowest);
                }
            }
            if (subBlock.size() > 0) {
                int[] subArr = new int[subBlock.size()];
                for (int j = 0; j < subBlock.size(); j++) {
                    subArr[j] = subBlock.get(j);
                }
                solution(subArr);
                subBlock.clear();
            }
        }
        return totalBlocks;
    }
}