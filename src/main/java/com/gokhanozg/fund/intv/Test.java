package com.gokhanozg.fund.intv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Gokhan Ozgozen on 27-Aug-18.
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(findLongestTile("6-3"));
//        System.out.println(findLongestTile("1-1,3-5,5-2,2-3,2-4"));
//        System.out.println(findLongestTile("1-1,3-5,5-2,2-3,2-4,6-2,6-8,1-4,4-3,3-5,5-2,5-1"));
//        System.out.println(findLongestTile("1-1"));
//        System.out.println(findLongestTile("1-2,1-2"));
//        System.out.println(findLongestTile("3-2,2-1,1-4,4-4,5-4,4-2,2-1"));
//        System.out.println(findLongestTile("5-5,5-5,4-4,5-5,5-5,5-5,5-5,5-5,5-5,5-5"));
//        System.out.println(findLongestTile("1-1,3-5,5-5,5-4,4-2,1-3"));
//        System.out.println(findLongestTile("1-2,2-2,3-3,3-4,4-5,1-1,1-2"));
//        printS(friendships(new String[]{"Anne:Barbara","Barbara:Ivan", "Vinny:Vlad"},new String[]{"Anne", "Vinny"}));
//        printS(friendships(new String[]{"Octavia:Zoltan", "Zoltan:Marko", "Marko:Diego", "Diego:Andres"},new String[]{"Octavia", "Diego"}));
        printS(friendships(new String[]{"Vanja:Sergio", "Sergio:Pedro", "Pedro:Martin", "Martin:Pablo", "Pablo:Sergio", "Jelena:Ivan", "Jelena:Alan", "Alan:Tomislav"}, new String[]{"Tomislav", "Martin"}));
        printS(friendships(new String[]{"Alvaro:Alex", "Roman:Nikola", "Octavia:Barbara", "Joao:Marko", "Luis:Vanja", "Gabriel:Gustavo", "Alan:Pablo", "Ivan:Andres", "Artem:Anne", "Martin:Alessandro", "Sebastian:Vinny", "Eduardo:Francis", "Zoltan:Vlad"}, new String[]{"Zoltan", "Ivan"}));
        printS(friendships(new String[]{"David:Francis", "Francis:Alessandro", "Alessandro:Ivan", "Tomislav:Ivan", "Anne:Tomislav", "Anne:David", "Francis:Tomislav"}, new String[]{"Francis", "David"}));
        printS(friendships(new String[]{"Alessandro:Anna", "Anna:Anne", "Anne:Barbara", "Barbara:David", "David:Francis", "Francis:Eduardo", "Eduardo:Anna", "Eduardo:Alessandro", "Luis:Marko", "Joao:Vlad", "Vlad:Luka", "Luka:Nikola", "Nikola:Roman", "Vlad:Roman", "Vlad:Vinny", "Vinny:Roman", "Vlad:Andres", "Vinny:Ivan"}, new String[]{"Barbara", "Joao"}));


    }

    static private void printS(String[] r) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r.length; i++) {
            sb.append(r[i]);
            if (i != r.length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }

    static private String[] friendships(String[] relationship, String[] query) {
        List<Set<String>> friends = new ArrayList<>();
        for (String relation : relationship) {
            String[] vals = relation.split(":");
            String p1 = vals[0];
            String p2 = vals[1];
            boolean exists = false;
            for (Set<String> friendSet : friends) {
                if (friendSet.contains(p1) || friendSet.contains(p2)) {
                    friendSet.add(p1);
                    friendSet.add(p2);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                Set<String> friendset = new HashSet<>();
                friendset.add(p1);
                friendset.add(p2);
                friends.add(friendset);
            }
        }
        String[] r = new String[query.length];
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            for (Set<String> friendSet : friends) {
                if (friendSet.contains(q)) {
                    r[i] = q + ":" + (friendSet.size() - 1);
                }
            }
        }
        return r;
    }

    static private int findLongestTile(String input) {
        String[] tiles = input.split(",");
        int maxChain = 1;
        int currentChain = 1;
        int prev = Integer.parseInt(tiles[0].split("-")[1]);
        for (int i = 1; i < tiles.length; i++) {
            String[] tile = tiles[i].split("-");
            int start = Integer.parseInt(tile[0]);
            int end = Integer.parseInt(tile[1]);
            if (start == prev) {
                currentChain++;
                maxChain = Math.max(maxChain, currentChain);
            } else {
                currentChain = 1;
            }
            prev = end;
        }
        return maxChain;
    }
}
