package com.training.leetcode;
public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {

        int p1 = s.length() - 1, p2 = t.length() - 1;

        while(p1 >=0 || p2 >= 0){
            int skip1 = 0, skip2 = 0;
            // Find next possible comparable character pos in s
            while(p1 >= 0){
                if(s.charAt(p1) == '#'){
                    p1--;
                    skip1++;
                } else if(skip1 > 0){
                    skip1--;
                    p1--;
                } else {
                    break;
                }
            }
            // Find next possible comparable character pos in t
            while(p2 >= 0){
                if(t.charAt(p2) == '#'){
                    p2--;
                    skip2++;
                } else if(skip2 > 0){
                    skip2--;
                    p2--;
                } else {
                    break;
                }
            }

            if(p1 >= 0 && p2 >= 0 && s.charAt(p1) != t.charAt(p2)) return false;

            if((p1 >= 0) != (p2 >= 0)) return false;

            p1--;
            p2--;
        }

        return true;
    }
}
