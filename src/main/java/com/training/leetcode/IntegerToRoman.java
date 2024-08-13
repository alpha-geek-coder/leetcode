package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        StringBuilder sb = new StringBuilder();
        int unit = 1, n = num;
        while(num / 10 > 0){
            num /= 10;
            unit *= 10;
        }

        while(n > 0){
            int digit = n / unit;

            if(digit >= 1 && digit <= 3){
                for(int i = 0; i < digit; i++){
                    sb.append(map.get(unit));
                }
//            } else if(digit == 5) {
//                sb.append(map.get(5 * unit));
            } else if(digit >= 5 && digit <= 8) {
                sb.append(map.get(5 * unit));
                for(int i = 0; i < digit - 5; i++){
                    sb.append(map.get(unit));
                }
            } else if(digit == 4 || digit == 9){
                sb.append(map.get(unit)).append(map.get((digit + 1) * unit));
            }

            n = n % unit;
            unit /= 10;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,25,40,50,58, 70,80,90, 100, 300, 400, 500, 700, 800, 900, 1000, 1200, 1309, 1410, 1505, 1819, 2000, 1994};
        for(int num : nums) {
            System.out.println(num + " -> " + new IntegerToRoman().intToRoman(num));
        }


    }
}
