package com.training.leetcode;

public class MyAtoi {

    public int myAtoi(String s) {
        //step 1 : initialise
        int num = 0;
        int idx = 0, sign = 1;

        //step 2: trim leading spaces
        while (idx < s.length() && s.charAt(idx) == ' ' ) {
            idx++;
        }

        //step 3: identify sign
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            sign = s.charAt(idx) == '+' ? 1 : -1;
            idx++;
        }
        while (idx < s.length()) {
            int digit = s.charAt(idx) - '0';
            if (digit < 0 || digit > 9) break;
            if(num > Integer.MAX_VALUE / 10  || num == Integer.MAX_VALUE / 10  && digit > 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            idx++;
        }


        return num;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi(" "));
    }
}
