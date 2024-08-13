package com.training.leetcode;

import java.util.Arrays;

public class CountUniqueChars {

    public int uniqueLetterString(String s) {

        int ans = 0;
        int n = s.length();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int[] charContribution = new int[26];
        for(int i = 0; i < n; i++){
//       Now, we need to update the contribution of curChar.
//       The total number of substrings ending at i are i+1. So if it was a unique character, it'd contribute to all of those
//       and it's contribution would have been i+1.
//       But if it's repeating, it means it has already contributed previously. So remove it's previous contribution.
//       We can do that as we have it's last position.
//       So these are the contributions for strings which start after this character's last occurrence and end at i.
//       A simple example will demonstrate that the number of these strings are i+1 - lastPosition[curChar]
//       For characters not appeared till now, lastPosition[curChar] would be 0.
            int curr = s.charAt(i) - 'A';
            charContribution[curr] = i - lastSeen[curr];
            for (int j = 0; j < 26; j++) {
                ans += charContribution[j];
            }
            lastSeen[curr] = i ;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountUniqueChars().uniqueLetterString("LEETCODE"));
    }

}
