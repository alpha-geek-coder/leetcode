package com.training.leetcode;

import java.util.Stack;

public class MakeTheStringGreat {

    public String makeGood(String s) {

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length() - 1; i+= 2) {
//
//            char s1 = s.charAt(i);
//            char s2 = s.charAt(i + 1);
//            if (s2 == Character.toUpperCase(s1) || s1 == Character.toUpperCase(s2)) {
//                continue;
//            } else {
//                sb.append(s1).append(s2);
//            }
//        }
//        return sb.toString();

//    int i = 0, n = s.length();
//        while( i < n ){
//            char c = s.charAt(i);
//            if(Character.isUpperCase(c)){
//                if(i - 1 >= 0 && s.charAt(i - 1) == Character.toLowerCase(c)){
//                    s = s.substring(0, i - 1) + s.substring(i + 1);
//                    n = s.length(); i = 0;
//                } else if(i + 1 < s.length() && s.charAt(i + 1) == Character.toLowerCase(c)){
//                    s = s.substring(0, i) + s.substring(i + 2); i = 0;
//                }
//            } else {
//                i++;
//            }
//
//        }
//
//        return s;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && Math.abs(stack.peek() - c) == 32){
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MakeTheStringGreat().makeGood("leEeetcode"));
        System.out.println(new MakeTheStringGreat().makeGood("abBAcC"));
        System.out.println(new MakeTheStringGreat().makeGood("s"));
    }
}
