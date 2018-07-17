package com.gokhanozg.fund.permComb;

import java.math.BigDecimal;

/**
 * Created by Mephalay on 17-Jul-18.
 */
public class TestUtil {
    public static void main(String[] args) {
        System.out.println(Util.calculateCombinationLong(10, 5));
        System.out.println(Util.calculateCombinationBig(new BigDecimal("100"), new BigDecimal("12")));
    }
}
