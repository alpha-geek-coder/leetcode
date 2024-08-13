package com.training.leetcode;

import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String s) {

        int l = 0, r = s.length() - 1;
        while(l < s.length() && s.charAt(l) == ' ') l++;
        while(l <= r && s.charAt(r) == ' ') r--;

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(l <= r){

            if(sb.length() != 0 && s.charAt(l) == ' '){
                stack.push(sb.toString());
                sb.setLength(0);
            } else if(s.charAt(l) != ' ') {
                sb.append(s.charAt(l));
            }
            l++;
        }
        stack.push(sb.toString());
        sb.setLength(0);

        while(!stack.isEmpty()){
            if(sb.length() != 0) sb.append(' ');
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseWords.reverseWords("  the   sky is blue  "));
    }
}
