package com.gokhanozg.fund.minHeap;

import java.util.Comparator;

/**
 * Created by Mephalay on 20-Jul-18.
 */
public class UpdatableHeap<T extends Comparable<T>> {

    private Comparator<T> comparator = null;


    private class Node {
        Node left;
        Node right;
        T val;
    }


}
