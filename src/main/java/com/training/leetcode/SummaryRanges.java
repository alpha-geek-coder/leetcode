package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Question: 228
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList();
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
//            int a = nums[i], b = nums[i];
//            while(i + 1 < n && nums[i + 1] - nums[i] == 1){
//                b = nums[++i];
//            }
//            if(a == b) ranges.add("\"" + a + "\"");
//            if(a != b) ranges.add("\"" + a + "->" + b + "\"" );
            if(!stack.isEmpty() && stack.peek() + 1 < nums[i]){
                getRange(stack, ranges);
            }

            stack.add(nums[i]);
        }
        if(!stack.isEmpty()){
            getRange(stack, ranges);
        }

        return ranges;
    }

    public void getRange(Stack<Integer> stack, List<String> ranges){
        int b = stack.peek(), a = b;
        while(!stack.isEmpty()){
            a = stack.pop();
        }
        if(a == b){
            ranges.add("" + a);
        } else {
            ranges.add(a + "->" + b );
        }
    }

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-10,-3,-2,-1,0,6,8,9,11}));
        System.out.println(5 / 5);
    }
}
