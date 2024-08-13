package com.training.leetcode;

public class ReverseStringII {
    public String reverseStr(String s, int k) {

        char[] str = s.toCharArray();

        for(int i = 0; i < str.length; i += 2 * k){
            int l = i, r = Math.min(l + k - 1, str.length - 1);
            while(l < r) {
                char tmp = str[r];
                str[r--] = str[l];
                str[l++] = tmp;
            }
        }

        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
        System.out.println(new ReverseStringII().reverseStr("abcd", 2));
        System.out.println(new ReverseStringII().reverseStr("abcdefg", 8));
    }
}
