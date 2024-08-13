package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    List<List<String>> list = new ArrayList();
    public List<List<String>> partition(String s) {

        backtrack(0, s, new ArrayList<String>());

        return list;
    }

    public void backtrack(int startIdx, String s, List<String> current) {
        System.out.println("Inside BT --> " + startIdx);
        if(startIdx == s.length()) {
            System.out.println("Inside BT --> " + startIdx + " result = " + current );
            list.add(new ArrayList(current));
            return;
        }

        for(int endIdx = startIdx ; endIdx < s.length() ; endIdx++) {

            String str = s.substring(startIdx, endIdx + 1);
            System.out.println("Inside BT loop --> " + startIdx + " " + endIdx + " string = " + str);
            if(isPalindrome(str)){
                System.out.println("Inside BT loop --> " + startIdx + " " + endIdx + " string = " + str + " add ");
                current.add(str);
                backtrack(endIdx + 1, s, current);
                System.out.println("Inside BT loop --> " + startIdx + " " + endIdx + " string = " + str + " remove ");
                current.remove(current.size() - 1);
            }

        }
    }

    public boolean isPalindrome(String str) {

        int left = 0, right = str.length() - 1;

        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new PalindromePartitioning().partition("aab");
        System.out.println("success");

    }
}
