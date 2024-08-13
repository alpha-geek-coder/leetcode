package com.training.leetcode;



public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {

        int i = 0, j = 0, nl = name.length(), tl = typed.length();

        while(i < nl && j < tl) {

            char nc = name.charAt(i);
            char tc = typed.charAt(j);
            if(nc != tc) return false;

            int count1 = 0;
            while(i < nl && name.charAt(i) == nc) {
                count1++;
                i++;
            }
            int count2 = 0;
            while(j < tl && typed.charAt(j) == tc) {
                count2++;
                j++;
            }
            if(count2 < count1) return false;
        }

        return i == nl && j == tl ;
    }

    public static void main(String[] args) {
        System.out.println(new LongPressedName().isLongPressedName("saeed","saeed"));
    }
}
