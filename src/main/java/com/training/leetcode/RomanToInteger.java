package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

        public int romanToInt(String s) {

            Map<Character, Integer> map = new HashMap();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            int num = 0, len = s.length();

            for(int i = 0; i < len; i++){

                char c = s.charAt(i);
                if(c == 'I' && i + 1 < len && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    num += map.get(s.charAt(i + 1)) - map.get(c);
                    i++;
                } else if(c == 'X' && i + 1 < len && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
                    num += map.get(s.charAt(i + 1)) - map.get(c);
                    i++;
                } else if(c == 'C' && i + 1 < len && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
                    num += map.get(s.charAt(i + 1)) - map.get(c);
                    i++;
                } else {
                    num += map.get(c) ;
                }
            }

            return num;
        }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MMMM"));
    }
}
