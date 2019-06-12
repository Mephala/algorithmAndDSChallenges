package com.gokhanozg.misc.test;

/**
 * Created by Gokhan Ozgozen on 12-Jun-19.
 */
public interface Convert<T, F> {
    F convert(T t);
}
