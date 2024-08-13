package com.training.leetcode;



public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {

        int count = 0;
        while(n > 0) {
            count += n /5;
            n = n / 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(9999));
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(10));
    }
}
