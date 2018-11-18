package com.gokhanozg.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Gokhan Ozgozen on 18-Nov-18.
 */
public class TestRandomMatch {


    public static void main(String[] args) {
        List<String> kisiler = new ArrayList<>();
        Random rand = new Random();
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));
        System.out.println(rand.nextInt(3));

        if (kisiler.size() == 1) {
            // eslestirme olmaz
            return;
        }
        int personIndex1 = rand.nextInt(kisiler.size());
        int personIndex2 = personIndex1;
        while (personIndex2 == personIndex1) {
            personIndex2 = rand.nextInt(kisiler.size());
        }
        String person1 = kisiler.get(personIndex1);
        String person2 = kisiler.get(personIndex2);
        // person1 ve person2 eslesti.
        kisiler.remove(person1);
        kisiler.remove(person2); // index ile degil, isim ile remove etmek mantikli, cunku index degisiyor remove/add sonrasi.


    }


}
