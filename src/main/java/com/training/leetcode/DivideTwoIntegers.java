package com.training.leetcode;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1) return (1 << 31) - 1;

//        int ans = 1, sum = divisor, sign = 1, target = dividend == Math.abs(dividend);
//
//        if(dividend < 0 && divisor < 0) {
//            sign = 1;
//        } else {
//            sign = dividend < 0 || divisor < 0 ? -1 : 1;
//        }
//
//        while(sum <= target) {
//
//            if(sign == 1 && (sum > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE / 10 == sum && sum % 10 > 7)) {
//                return Integer.MAX_VALUE ;
//            }
//
//            if(sign == -1 && (sum < Integer.MIN_VALUE / 10 || Integer.MIN_VALUE / 10 == sum*sign && sum*sign % 10 < -8)) {
//                return Integer.MIN_VALUE;
//            }
//            sum += divisor;
//            ans++;
//        }
//
//        return (ans - 1);

        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    public static void main(String[] args) {

        System.out.println(new DivideTwoIntegers().divide(-2147483648, 1));
    }
}
