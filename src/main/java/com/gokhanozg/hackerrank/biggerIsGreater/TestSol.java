package com.gokhanozg.hackerrank.biggerIsGreater;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * Created by Gokhan Ozgozen on 01-Aug-18.
 */
public class TestSol {
    public static void main(String[] args) {
        boolean debug = true;
//        System.out.println(Solution.biggerIsGreater("ab"));
//        System.out.println(Solution.biggerIsGreater("bb"));
//        System.out.println(Solution.biggerIsGreater("hefg"));
//        System.out.println(Solution.biggerIsGreater("dhck"));
//        System.out.println(Solution.biggerIsGreater("dkhc"));
//        System.out.println(Solution.biggerIsGreater("z"));
//        System.out.println(Solution.biggerIsGreater("abdef"));
        System.out.println("biehzcmjckznhwrfgglverxsezxuqpj");
        System.out.println(Solution.biggerIsGreater("biehzcmjckznhwrfgglverxsezxuqpj"));
        System.out.println("biehzcmjckznhwrfgglverxsjepquxz");
//        System.out.println("dldmsym");
//        System.out.println("dldmyms");
//        System.out.println(Solution.biggerIsGreater("dldmsym"));
        if (debug) {
            try {
                URL url = TestSol.class.getClassLoader().getResource("biggerIsGreater/query.txt");
                File f = new File(url.getPath());
                List<String> queries = FileUtils.readLines(f);
                url = TestSol.class.getClassLoader().getResource("biggerIsGreater/answers.txt");
                f = new File(url.getPath());
                List<String> answers = FileUtils.readLines(f);
                for (int i = 0; i < queries.size(); i++) {
                    String q = queries.get(i);
                    String answer = answers.get(i);
                    String myAns = Solution.biggerIsGreater(q);
                    if (!myAns.equals(answer)) {
                        System.out.println("Failing txt: " + q);
                        System.out.println("Correct ans: " + answer);
                        System.out.println("My      ans: " + myAns);
                        break;
                    }
                }
                System.out.println("Huge Success");
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }

    }
}
