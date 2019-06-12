package com.gokhanozg.misc.test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * Created by Gokhan Ozgozen on 12-Jun-19.
 */
public class Lambda {
    public static void main(String[] args) {
        Consumer<Person> personConsumer = (p) -> System.out.println(String.format("Hey %s %s", p.name, p.surname));
        Person p = new Person();
        p.name = "Gokhan";
        p.surname = "Ozgozen";
        personConsumer.accept(p);

        final int lim = 4000000;
        List<String> randomStrs = new ArrayList<>();
        for (int i = 0; i < lim; i++) {
            randomStrs.add(UUID.randomUUID().toString());
        }

        long t1 = System.nanoTime();
        long count = randomStrs.stream().sorted().count();
        long t2 = System.nanoTime();
        System.out.println(String.format("%s elements sorted sequentially in %s milliseconds", count, TimeUnit.NANOSECONDS.toMillis(t2 - t1)));

        long t3 = System.nanoTime();
        count = randomStrs.parallelStream().sorted().count();
        long t4 = System.nanoTime();
        System.out.println(String.format("%s elements sorted in parallel in %s milliseconds", count, TimeUnit.NANOSECONDS.toMillis(t4 - t3)));
    }

    static class Person {
        String name;
        String surname;
    }
}
