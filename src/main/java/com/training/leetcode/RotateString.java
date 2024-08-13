package com.training.leetcode;



public class RotateString {
    public boolean rotateString(String s, String goal) {

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == goal.charAt(0)){
                int j = i + 1 % s.length();
                int g = 1;
                while(i != j && g < goal.length() && s.charAt(j) == goal.charAt(g)){
                    g++; j = (j + 1) % s.length();
                }
                if(g == goal.length()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
    }
}
