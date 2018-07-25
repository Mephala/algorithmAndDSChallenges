package com.gokhanozg.misc.bloodyTable;

/**
 * Created by Mephalay on 22-Jul-18.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Around a round table, n number of people are dining. 1 person kills the one at his right, and passes the knife to
 * the second person on his right. This goes on until there is only a single survivor.
 */
public class BloodyTable {

    public static int run(int totalPeople) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= totalPeople; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            if (index + 1 == list.size()) {
                //we are at last element
                list.remove(0);
                index = 0;
            } else if (index + 1 > list.size()) {
                list.remove(1);
                index = 1;
            } else {
                list.remove(index + 1);
                index++;
            }
        }
        return list.get(0);
    }
}
