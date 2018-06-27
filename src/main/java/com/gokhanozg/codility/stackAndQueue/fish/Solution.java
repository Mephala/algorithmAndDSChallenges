package com.gokhanozg.codility.stackAndQueue.fish;

import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> upstreamStack = new Stack<>();
        Stack<Integer> downStreamStack = new Stack<>();
        int ignoredFishCount = 0;
        // 0 = upstream
        // 1 = downstream
        boolean downStreamDetected = false;
        for (int i = 0; i < A.length; i++) {
            if (!downStreamDetected && B[i] == 0) {
                ignoredFishCount++; //this fish won't encounter any other fish.
            } else if (!downStreamDetected && B[i] == 1) {
                downStreamDetected = true;
                downStreamStack.push(A[i]);
            } else if (downStreamDetected && B[i] == 1) {
                downStreamStack.push(A[i]);
                removeSmallerFish(upstreamStack, downStreamStack);
            } else {
                // downStreamDetected and fish is moving upstream
                upstreamStack.push(A[i]);
                removeSmallerFish(upstreamStack, downStreamStack);
            }
        }
        return upstreamStack.size() + downStreamStack.size() + ignoredFishCount;
    }

    private void removeSmallerFish(Stack<Integer> upstreamStack, Stack<Integer> downStreamStack) {
        while (!upstreamStack.empty() && !downStreamStack.empty()) {
            if (upstreamStack.peek() > downStreamStack.peek()) {
                downStreamStack.pop();
            } else {
                upstreamStack.pop();
            }
        }
    }
}