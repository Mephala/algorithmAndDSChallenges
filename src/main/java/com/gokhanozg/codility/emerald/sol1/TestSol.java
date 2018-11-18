package com.gokhanozg.codility.emerald.sol1;

/**
 * Created by Gokhan Ozgozen on 18-Nov-18.
 */
public class TestSol {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("Sun 10:00-20:00\nFri 05:00-10:00\nFri 16:30-23:50\nSat 10:00-24:00\nSun 01:00-04:00\nSat 02:00-06:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nMon 05:00-13:00\nMon 15:00-21:00"));
        System.out.println(s.solution("Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00"));
        System.out.println(s.solution("Mon 00:00-24:00\nTue 00:00-24:00\nWed 00:00-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution("Mon 06:00-24:00\nTue 00:00-24:00\nWed 00:00-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution("Mon 06:00-24:00\nTue 00:00-24:00\nWed 00:00-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-17:00"));
        System.out.println(s.solution("Mon 00:00-24:00\nTue 00:00-12:58\nTue 13:13-24:00\nWed 00:00-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution("Mon 00:00-24:00\nTue 00:00-23:59\nWed 00:02-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution("Mon 00:00-24:00\nTue 00:00-23:59\nWed 00:00-24:00\nThu 00:00-23:58\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution("Mon 00:00-24:00\nWed 00:00-24:00\nThu 00:00-24:00\nFri 00:00-24:00\nSat 00:00-24:00\nSun 00:00-24:00"));
        System.out.println(s.solution(null));
        System.out.println(s.solution(""));
    }
}
