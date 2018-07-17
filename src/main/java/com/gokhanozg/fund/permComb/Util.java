package com.gokhanozg.fund.permComb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mephalay on 17-Jul-18.
 */
public class Util {


    private static Map<Long, Long> factorialCache = new HashMap<>();
    private static Map<BigDecimal, BigDecimal> factorialCacheBig = new HashMap<>();


    private static Long calculateFactorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial can not be calculated for integers lower than zero.");
        }
        if (factorialCache.containsKey(n)) {
            return factorialCache.get(n);
        }
        if (n == 0) {
            factorialCache.put(0L, 1L);
            return 1L;
        } else if (n == 1) {
            factorialCache.put(1L, 1L);
            return 1L;
        } else {
            long retval = n * calculateFactorial(n - 1);
            factorialCache.put(n, retval);
            return retval;
        }
    }


    public static long calculateCombinationLong(long n, long r) {
        if (r > n) {
            throw new IllegalArgumentException("r must be lower than n");
        }
        long nrdif = n - r;
        long nres;
        long rres;
        long rnres;
        if (nrdif < r) {
            rnres = calculateFactorial(nrdif);
            rres = calculateFactorial(r);
        } else {
            rres = calculateFactorial(r);
            rnres = calculateFactorial(nrdif);
        }
        nres = calculateFactorial(n);
        return nres / (rres * rnres);
    }

    public static BigDecimal calculateCombinationBig(BigDecimal n, BigDecimal r) {
        if (r.compareTo(n) == 1) {
            throw new IllegalArgumentException("r must be lower than n");
        }
        BigDecimal nrdif = n.subtract(r);
        BigDecimal nres;
        BigDecimal rres;
        BigDecimal nrres;
        if (nrdif.compareTo(r) == -1) {
            nrres = calculateFactorialBig(nrdif);
            rres = calculateFactorialBig(r);
        } else {
            rres = calculateFactorialBig(r);
            nrres = calculateFactorialBig(nrdif);
        }
        nres = calculateFactorialBig(n);
        return nres.divide(rres.multiply(nrres));
    }

    private static BigDecimal calculateFactorialBig(BigDecimal n) {
        if (n.compareTo(BigDecimal.ZERO) == -1) {
            throw new IllegalArgumentException("Factorial can not be calculated for integers lower than zero.");
        }
        if (factorialCacheBig.containsKey(n)) {
            return factorialCacheBig.get(n);
        }
        if (n.equals(BigDecimal.ZERO)) {
            factorialCacheBig.put(BigDecimal.ZERO, BigDecimal.ONE);
            return BigDecimal.ONE;
        } else if (n.equals(BigDecimal.ONE)) {
            factorialCacheBig.put(BigDecimal.ONE, BigDecimal.ONE);
            return BigDecimal.ONE;
        } else {
            BigDecimal retval = n.multiply(calculateFactorialBig(n.subtract(BigDecimal.ONE)));
            factorialCacheBig.put(n, retval);
            return retval;
        }
    }
}
