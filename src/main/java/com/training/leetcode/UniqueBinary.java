package com.training.leetcode;

import java.util.Arrays;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueBinary {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<String> seen = new HashSet<>(Arrays.asList(nums));

        for(String num : nums){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < num.length(); i++){
                if(num.charAt(i) == '1'){
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
            if(!seen.contains(sb.toString())) return sb.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinary().findDifferentBinaryString(new String[]{"00", "01"}));

    }
}
