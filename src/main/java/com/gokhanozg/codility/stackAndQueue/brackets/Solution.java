package com.gokhanozg.codility.stackAndQueue.brackets;

import java.util.Stack;

class Solution {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '}') {
                if (!stack.empty() && stack.peek().equals('{')) {
                    stack.pop();
                } else {
                    return 0;
                }
            } else if (c == ')') {
                if (!stack.empty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    return 0;
                }
            } else if (c == ']') {
                if (!stack.empty() && stack.peek().equals('[')) {
                    stack.pop();
                } else {
                    return 0;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }
}