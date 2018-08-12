package com.gokhanozg.codility.treeHeight;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

class Solution {
    public int solution(Tree T) {
        // write your code in Java SE 8
        return calcH(T);
    }

    private int calcH(Tree t) {
        if (t == null) {
            return 0;
        }
        return 1 + Math.max(calcH(t.l), calcH(t.r));
    }
}