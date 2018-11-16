package com.gokhanozg.custom;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Gokhan Ozgozen on 16-Nov-18.
 */
public class Fibo extends RecursiveTask<Integer> {
    private final int val;

    public Fibo(int val) {
        this.val = val;
    }


    @Override
    protected Integer compute() {
        if (val <= 1) {
            return val;
        }
        Fibo f1 = new Fibo(val - 1);
        f1.fork();
        Fibo f2 = new Fibo(val - 2);
        return f2.compute() + f1.join();
    }
}
