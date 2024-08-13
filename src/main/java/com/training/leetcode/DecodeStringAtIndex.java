package com.training.leetcode;

public class DecodeStringAtIndex {
    public String decodeAtIndex(String s, int k) {

        long decoded_str_len = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                decoded_str_len *= s.charAt(i) - '0';
            } else {
                decoded_str_len++;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                decoded_str_len /= c - '0';
                k %= decoded_str_len;
            }else {
                if(k == 0 || decoded_str_len == k) return String.valueOf(c);
                decoded_str_len--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new DecodeStringAtIndex().decodeAtIndex("leet2code3", 10));
    }
}
