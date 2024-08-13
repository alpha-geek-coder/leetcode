package com.training.leetcode;

import java.util.Stack;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int m = nums1.length, n = nums2.length;
        int[] ans = new int[k];
        // k <= m + n
        for(int nums1_len = 0; nums1_len <= k; nums1_len++){
            int nums2_len = k - nums1_len;

            if(nums1_len > m || nums2_len > n) continue;
            int[] max1 = getLargestNumber(nums1, nums1_len);
            int[] max2 = getLargestNumber(nums2, nums2_len);
            int[] max_num = merge(max1, max2);
            if(isMax(max_num,0, ans, 0)){
                ans = max_num;
            }

        }

        return ans;

    }

    public int[] getLargestNumber(int[] nums, int max_len){
        int n = nums.length, drop_elements = n - max_len;
        int[] ans = new int[max_len];
        Stack<Integer> stack = new Stack();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && drop_elements > 0 &&  stack.peek() < nums[i]){
                stack.pop();
                drop_elements--;
            }
            stack.push(nums[i]);
        }

        int i = max_len - 1;
        while(!stack.isEmpty()) ans[i--] = stack.pop();

        return ans;
    }

    public int[] merge(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        int[] ans = new int[m + n];
        int i = 0, j = 0, idx = 0;

        while(idx < ans.length){
            ans[idx++] = isMax(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }

        return ans;

    }

    public boolean isMax(int[] nums1, int i, int[] nums2, int j){
        int m = nums1.length, n = nums2.length;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                return false;
            } else if(nums1[i] > nums2[j]) {
                return true;
            } else {
                i++; j++;
            }

        }
        return i != m;
    }

    public static void main(String[] args) {
        System.out.println(new CreateMaximumNumber().maxNumber(new int[]{6,7}, new int[]{6,0,4}, 5));
    }
}
