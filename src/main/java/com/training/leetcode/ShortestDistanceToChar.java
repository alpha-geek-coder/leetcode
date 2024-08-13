package com.training.leetcode;

public class ShortestDistanceToChar {

    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] output = new int[n];

        int prev = Integer.MIN_VALUE / 2;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == c) prev = i;
            output[i] = i - prev;
        }

        prev = Integer.MIN_VALUE / 2;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == c) prev = i;
            output[i] = Math.min(output[i], prev - i);
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestDistanceToChar().shortestToChar("loveleetcode", 'e'));

    }
}
