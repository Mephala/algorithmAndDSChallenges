package com.gokhanozg.custom;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Gokhan Ozgozen on 16-Nov-18.
 */
public class BQ {

    private final int limit = 10;
    private Queue<String> queue = new LinkedList<>();

    protected synchronized int getSize() {
        return queue.size();
    }

    protected synchronized void put(String s) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }
        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(s);
    }

    protected synchronized String get() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == limit) {
            notifyAll();
        }
        return queue.poll();
    }

}
