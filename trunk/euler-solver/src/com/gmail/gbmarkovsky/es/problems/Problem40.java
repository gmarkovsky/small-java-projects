package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem40 implements EulerProblem {

    @Override
    public String solve() {
        StringBuilder result = new StringBuilder();
        long counter = 1;
        while (result.length() < 1000000) {
           result.append(counter++); 
        }
        Integer i = Integer.parseInt(Character.toString(result.charAt(0))) * 
                Integer.parseInt(Character.toString(result.charAt(9))) * 
                Integer.parseInt(Character.toString(result.charAt(99))) * 
                Integer.parseInt(Character.toString(result.charAt(999))) * 
                Integer.parseInt(Character.toString(result.charAt(9999))) * 
                Integer.parseInt(Character.toString(result.charAt(99999))) * 
                Integer.parseInt(Character.toString(result.charAt(999999)));
        return i.toString();
    }

}
