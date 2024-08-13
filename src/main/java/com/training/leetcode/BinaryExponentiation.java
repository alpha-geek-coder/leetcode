package com.training.leetcode;

public class BinaryExponentiation {
    public long findExponentOf(int num, int power){
        long ans = 1; // base case: num ^ 0 ==> 1
        while(power > 0){
            // power is odd
            if((power & 1) == 1){
                ans *= num;
            }
            num *= num;
            power >>= 1; // divide by 2
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryExponentiation().findExponentOf(2, 12));
    }
}
