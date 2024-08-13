package com.training.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionInString {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();

        String sign = (numerator < 0 == denominator < 0 || numerator == 0 ? "" : "-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        sb.append(sign);
        sb.append(num / den);

        long remainder = num % den;

        if(remainder == 0) {
            return sb.toString();
        }
        sb.append(".");

        Map<Long, Integer> map = new HashMap();
        while(remainder != 0) {
            if(!map.containsKey(remainder)) {
                map.put(remainder, sb.length());
            } else {
                int idx = map.get(remainder);
                return sb.substring(0, idx) + "(" + sb.substring(idx) + ")";
            }

            sb.append(10 * remainder  / den);
            remainder = 10 * remainder % den;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionInString().fractionToDecimal(4,333));
    }
}
