package com.gokhanozg.codility.emerald.sol1;// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String S) {
        final int weekEndMin = 7 * 24 * 60;
        if (S == null || S.isEmpty()) {
            return weekEndMin;
        }
        String[] times = S.split("\n");
        List<TimeSlot> timeSlots = new ArrayList<>();
        for (String time : times) {
            timeSlots.add(new TimeSlot(time));
        }
        Collections.sort(timeSlots);

        if (timeSlots.size() == 0) {
            return weekEndMin;// sleep whole week
        }
        int longestSleep = -1;
        int currentMin = 0;
        for (TimeSlot timeSlot : timeSlots) {
            int possibleSleep = Math.abs(currentMin - timeSlot.start);
            longestSleep = Math.max(longestSleep, possibleSleep);
            currentMin = timeSlot.end;
        }
        int possibleSleep = Math.abs(currentMin - weekEndMin);
        longestSleep = Math.max(longestSleep, possibleSleep);
        return longestSleep;
    }


    class TimeSlot implements Comparable<TimeSlot> {
        final int day;
        final int start;
        final int end;
        final String humanReadable;

        TimeSlot(String s) {
            this.humanReadable = s;
            String[] vals = s.split(" ");
            String day = vals[0];
            String hours = vals[1];
            this.day = ordinalize(day);
            String[] startEndHours = hours.split("-");
            this.start = calcMinMark(startEndHours[0]);
            this.end = calcMinMark(startEndHours[1]);
        }

        @Override
        public String toString() {
            return "TimeSlot{" +
                    "start=" + start +
                    ", humanReadable='" + humanReadable + '\'' +
                    '}';
        }

        private int calcMinMark(String s) {
            String[] vals = s.split(":");
            return this.day * 24 * 60 + Integer.parseInt(vals[0]) * 60 + Integer.parseInt(vals[1]);
        }

        private int ordinalize(String day) {
            switch (day) {
                case "Mon":
                    return 0;
                case "Tue":
                    return 1;
                case "Wed":
                    return 2;
                case "Thu":
                    return 3;
                case "Fri":
                    return 4;
                case "Sat":
                    return 5;
                case "Sun":
                    return 6;
            }
            return -1;
        }

        @Override
        public int compareTo(TimeSlot o) {
            return Integer.compare(this.start, o.start);
        }
    }


}