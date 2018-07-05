package com.gokhanozg.codility.stackAndQueue.fish;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> upstreamStack = new Stack<>();
        Stack<Integer> downStreamStack = new Stack<>();
        Map<Integer, Integer> fishSizeToPosition = new HashMap<>();
        int ignoredFishCount = 0;
        // 0 = upstream
        // 1 = downstream
        boolean downStreamDetected = false;
        for (int i = 0; i < A.length; i++) {
            fishSizeToPosition.put(A[i], i);
            if (!downStreamDetected && B[i] == 0) {
                ignoredFishCount++; //this fish won't encounter any other fish.
            } else if (!downStreamDetected && B[i] == 1) {
                downStreamDetected = true;
                downStreamStack.push(A[i]);
            } else if (downStreamDetected && B[i] == 1) {
                downStreamStack.push(A[i]);
                removeSmallerFish(upstreamStack, downStreamStack, fishSizeToPosition);
            } else {
                // downStreamDetected and fish is moving upstream
                upstreamStack.push(A[i]);
                removeSmallerFish(upstreamStack, downStreamStack, fishSizeToPosition);
            }
        }
        return upstreamStack.size() + downStreamStack.size() + ignoredFishCount;
    }

    private void removeSmallerFish(Stack<Integer> upstreamStack, Stack<Integer> downStreamStack, Map<Integer, Integer> fishSizeToPosition) {
        boolean encounter = !upstreamStack.empty() && !downStreamStack.empty();
        while (encounter) {
            if (upstreamStack.peek() > downStreamStack.peek() && fishSizeToPosition.get(upstreamStack.peek()) > fishSizeToPosition.get(downStreamStack.peek())) {
                downStreamStack.pop();
                encounter = !upstreamStack.empty() && !downStreamStack.empty();
            } else if (upstreamStack.peek() < downStreamStack.peek() && fishSizeToPosition.get(upstreamStack.peek()) > fishSizeToPosition.get(downStreamStack.peek())) {
                upstreamStack.pop();
                encounter = !upstreamStack.empty() && !downStreamStack.empty();
            } else {
                encounter = false;
            }
        }
    }
}