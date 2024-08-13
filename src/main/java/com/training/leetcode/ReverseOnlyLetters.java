package com.training.leetcode;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {

        int left = 0, right = s.length() - 1;

        char[] chars = s.toCharArray();

        while(left < right){
            int lc = Character.toLowerCase(chars[left]) - 'a';
            int rc = Character.toLowerCase(chars[right]) - 'a';

            if(lc >= 0 && lc < 26 && rc >= 0 && rc < 26){
                swap(left, right, chars);
                left++;
                right--;
            } else if(lc < 0 || lc > 26) {
                left++;
            } else {
                right--;
            }
        }

        return new String(chars);
    }

    public void swap(int i, int j, char[] chars) {
        char tmp = chars[j];
        chars[j] = chars[i];
        chars[i] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj"));
    }
}
