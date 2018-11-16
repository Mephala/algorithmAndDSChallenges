package com.gokhanozg.custom;

import java.util.UUID;

/**
 * Created by Gokhan Ozgozen on 16-Nov-18.
 */
public class TestBQ {

    public static void main(String[] args) throws InterruptedException {
        final int lim = 20;
        BQ bq = new BQ();
        Thread pt1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < lim; i++) {
                        bq.put(UUID.randomUUID().toString());
                        System.out.println("Put from thread 1, size:" + bq.getSize());
                    }
                } catch (Throwable t) {
                    System.err.println("Error in thread 1");
                    t.printStackTrace();
                }

            }
        });
        Thread pt2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < lim; i++) {
                        bq.put(UUID.randomUUID().toString());
                        System.out.println("Put from thread 2, size:" + bq.getSize());
                    }
                } catch (Throwable t) {
                    System.err.println("Error in thread 2");
                    t.printStackTrace();
                }

            }
        });
        Thread pt3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < lim; i++) {
                        System.out.println("Get from pt3:" + bq.get() + ", size:" + bq.getSize());
                    }
                } catch (Throwable t) {
                    System.err.println("Error in thread 3");
                    t.printStackTrace();
                }

            }
        });
        Thread pt4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < lim; i++) {
                        System.out.println("Get from pt4:" + bq.get() + ", size:" + bq.getSize());
                    }
                } catch (Throwable t) {
                    System.err.println("Error in thread 4");
                    t.printStackTrace();
                }

            }
        });
        pt1.start();
//        pt2.start();
//        pt3.start();
        pt4.start();
        pt1.join();
//        pt2.join();
//        pt3.join();
        pt4.join();
    }
}
