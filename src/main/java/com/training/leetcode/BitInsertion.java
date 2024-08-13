package com.training.leetcode;

public class BitInsertion {
    public int updateBits(int n, int m, int i, int j){

       if(i > j || i <= 0 || j >= 32) return 0;

       // Create a mask to clear bit from i through j in n
       int allOnes = ~0; // all sequence of 1s

        //1s before j
        int left = j < 31 ? (allOnes << (j + 1)) : 0;

        System.out.println(Integer.toBinaryString(left));
        //1s after i
        int right = (1 << i) - 1;
        System.out.println(Integer.toBinaryString(right));

        int mask = left | right;
        System.out.println(Integer.toBinaryString(mask));

        int ans = (n & mask) | (m << i);

        System.out.println(Integer.toBinaryString(ans));

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BitInsertion().updateBits(Integer.parseInt("10000000000", 2), Integer.parseInt("10011", 2), 2, 6));
    }
}
