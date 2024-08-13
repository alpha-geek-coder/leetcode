package com.training.leetcode;

public class MinChangesToMake {
    public int minOperations(String s) {

//        if(s.length() == 1) return 0;
//
//        int search1 = s.charAt(0) == '0' ? 1 : 0;
//        int search2 = search1 ^ 1;
//        int count1 = 0, count2 = 1;
//        for(int i = 1; i < s.length(); i++){
//            int n = s.charAt(i) - '0';
//            if(n != search1) count1++;
//            if(n != search2) count2++;
//            search1 ^= 1;
//            search2 ^= 1;
//        }
//
//        return Math.min(count1, count2);


        int res = 0, n = s.length();
        // index is [0,1,2,3,...] with i % 2 = [0,1,0,1,0,1...]
        for (int i = 0; i < n; ++i)
            if (s.charAt(i) - '0' != i % 2)
                res++;
        return Math.min(res, n - res);
    }

    public static void main(String[] args) {
        System.out.println(new MinChangesToMake().minOperations("10010100"));

        System.out.println(new MinChangesToMake().minOperations("0100"));
        System.out.println(new MinChangesToMake().minOperations("0000"));
        System.out.println(new MinChangesToMake().minOperations("01"));
        System.out.println(new MinChangesToMake().minOperations("10"));
        System.out.println(new MinChangesToMake().minOperations("1111"));

    }
}
