package com.gmail.gbmarkovsky.es.problems;

import com.gmail.gbmarkovsky.es.EulerProblem;

public class Problem48 implements EulerProblem {

    @Override
    public String solve() {
        int[] number = new int[10];
        for (int i = 1; i < 10; i++) {
            int[] del = del(i);
            for (int j = 0; j < i; j++) {
                add(number, del);
            }
        }
        return arrayToSrting(number) + " wrong";
    }
    
    public void add(int[] number, int[] a) {
        for (int i = 0; i < a.length; i++) {
            int sum = number[i] + a[i];
            
            number[i] = sum % 10;
            int carry = sum / 10;
            for (int j = i + 1; j < number.length; j++) {
                int s = number[j] + carry;
                number[j] = s % 10;
                carry = s / 10;
                if (carry == 0)
                    break;
            }
        }
    }
    
    public int[] del(int num) {
        String string = Integer.toString(num);
        int[] result = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = Integer.parseInt(Character.toString(string.charAt(string.length() - 1 - i)));
        }
        return result;
    }
    
    public String arrayToSrting(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
        }
        return result.reverse().toString();
    }
    
    public int[] selfPower(int n) {
        int[] result = new int[10];
        String bs = Integer.toBinaryString(n);
        
        for (int i = 0; i < bs.length(); i++) {

        }
        
        return result;
    }
}
