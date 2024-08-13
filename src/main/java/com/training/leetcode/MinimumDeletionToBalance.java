package com.training.leetcode;

import java.util.Stack;
/*
 * You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

 

Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").
Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.
 

Constraints:

1 <= s.length <= 105
s[i] is 'a' or 'b'​​.
 */
public class MinimumDeletionToBalance {
    public int minimumDeletions(String s) {
        // // Approach 1 : 3-pass 
        // int n = s.length();
        // int[] b_count = new int[n];
        // int[] a_count = new int[n];

        // int b = 0;
        // for (int idx = 0; idx < n; idx++) {
        //     b_count[idx] = b;
        //     if(s.charAt(idx) == 'b') b++;
        // }

        // int a = 0;
        // for (int idx = n - 1; idx >= 0; idx--) {
        //     a_count[idx] = a;
        //     if(s.charAt(idx) == 'a') a++;
        // }

        // int ans = 0;
        // for (int i = 0; i < n; i++) {
        //     ans += Math.min(a_count[i], b_count[i]);
        // }

        // return ans;

        // Approach : One-pass using stack

        Stack<Character> stack = new Stack<>();
        int min_deletion = 0;

        for(int i = 0; i < s.length(); i++){
            if(!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a'){
                stack.pop();
                min_deletion++;
            } else {
                stack.push(s.charAt(i));
            }
        }

        return min_deletion;
    }
    public static void main(String[] args) {
        System.out.println(new MinimumDeletionToBalance().minimumDeletions("aababbab"));
    }
    
}
