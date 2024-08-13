package com.training.leetcode;

public class RepeatedSubstring {

    public boolean repeatedSubstringPattern(String s) {
        int[] pattern = buildPattern(s);

        int length = s.length(); //
        //pattern[length - 1] > 0 denotes last char had a prefix too
        // e.g. s = "ABAB" which has pattern = [0, 0, 1, 2]
        // i.e. len = 4 and pattern[len - 1] = 2, len - pattern[4 - 1] = 4 - 2 = 2 i.e. 2 recurring substring pattern of len = 2
        // e.g. s = "ABABCD" which has pattern = [0, 0, 1, 2, 0, 0]
        // i.e. len = 6 and pattern[6 - 1] = 0, no recurring substring pattern found, hence false;

        return (pattern[length - 1] > 0 && length % (length - pattern[length - 1]) == 0);
    }

    public int[] buildPattern(String s){

        int i = 1, prevLPS = 0, n = s.length();
        int[] pattern = new int[n];

        while(i < n){
            char prefix = s.charAt(prevLPS);
            char suffix = s.charAt(i);
            if(prefix == suffix){
                pattern[i++] = ++prevLPS;
            } else if(prevLPS == 0){
                pattern[i++] = 0;
            } else {
                prevLPS = pattern[prevLPS - 1];
            }
        }

        return pattern;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abab"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("aba"));
        System.out.println(new RepeatedSubstring().repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(new RepeatedSubstring().buildPattern("aabbaaabba"));
        System.out.println(Integer.highestOneBit(33));
        int i = 17;
        System.out.println(Integer.toBinaryString(i));
        i |= (i >>  1);
        System.out.println("i| i >> 1 " + Integer.toBinaryString(i));
        i |= (i >>  2);
        System.out.println("i| i >> 2 " + Integer.toBinaryString(i));
        i |= (i >>  4);
        System.out.println("i| i >> 4 " + Integer.toBinaryString(i));
        i |= (i >>  8);
        System.out.println("i| i >> 8 " + Integer.toBinaryString(i));
        i |= (i >> 16);
        System.out.println("i| i >> 16 " + Integer.toBinaryString(i));
        int j = (i >>> 1);
        System.out.println(j + "->" +Integer.toBinaryString(j));
        int k = i - j;
        System.out.println(k + "->" + i + " " +Integer.toBinaryString(k));

        int area = 37;

        for(int w = (int) Math.sqrt(area); w > 0; w--){
            int l = area / w;
            if(l * w == area){
                System.out.println(new int[]{l, w});
            }
        }

    }

}
