package com.gokhanozg.fund.problems.p2;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;

class Solution {

    public int[] solution(int[] T) {
        Map<Integer, Node> cityValToNode = new HashMap<>();
        Node capital = null;
        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                capital = new Node(i, i);
                cityValToNode.put(i, capital);
            } else {
                if (cityValToNode.containsKey(i)) {
                    cityValToNode.get(i).connects = T[i];
                } else {
                    Node c1 = new Node(i, T[i]);
                    cityValToNode.put(i, c1);
                }
                if (cityValToNode.containsKey(T[i])) {
                    cityValToNode.get(T[i]).otherConnect.add(i);
                } else {
                    Node c2 = new Node(T[i], -1);
                    c2.otherConnect.add(i);
                    cityValToNode.put(T[i], c2);
                }
            }
        }
        Map<Integer, List<Integer>> distanceNodes = new HashMap<>();
        distanceNodes.put(0, capital.otherConnect);
        for (int i = 1; i < T.length - 1; i++) {
            List<Node> nodes = new ArrayList<>();
            List<Integer> connectedCities = new ArrayList<>();
            connectedCities = distanceNodes.get(i - 1);
            for (Integer connectedCity : connectedCities) {
                Node city = cityValToNode.get(connectedCity);
                nodes.add(city);
            }
            List<Integer> furtherCities = new ArrayList<>();
            for (Node node : nodes) {
                furtherCities.addAll(node.otherConnect);
            }
            distanceNodes.put(i, furtherCities);
        }
        int[] r = new int[T.length - 1];
        for (int i = 0; i < r.length; i++) {
            r[i] = distanceNodes.get(i).size();
        }
        return r;

    }

    class Node {
        int city;
        int connects;
        List<Integer> otherConnect;

        Node(int city, int connects) {
            this.city = city;
            this.connects = connects;
            this.otherConnect = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return city == node.city &&
                    connects == node.connects &&
                    otherConnect == node.otherConnect;
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, connects, otherConnect);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "city=" + city +
                    '}';
        }
    }
}