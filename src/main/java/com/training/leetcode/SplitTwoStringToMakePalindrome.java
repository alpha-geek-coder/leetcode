package com.training.leetcode;

public class SplitTwoStringToMakePalindrome {

    /*
    You are given two strings a and b of the same length. Choose an index and split both strings at the same index,
    splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix
     where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

    When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty.
    For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

    Return true if it is possible to form a palindrome string, otherwise return false.

    Notice that x + y denotes the concatenation of strings x and y.
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return checkPalindrome(a,b) || checkPalindrome(b, a);
    }

    public boolean checkPalindrome(String first, String second) {
        int left = 0, right = first.length() - 1;

        while(left < right) {
            if(first.charAt(left) != second.charAt(right)) break;
            left++;
            right--;
        }

        if (left >= right) return true;

        return isPalindrome(first, left, right) || isPalindrome(second, left, right);
    }

    public boolean isPalindrome(String s, int left, int right) {

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitTwoStringToMakePalindrome().checkPalindromeFormation("abdef", "fecab"));
    }
}
