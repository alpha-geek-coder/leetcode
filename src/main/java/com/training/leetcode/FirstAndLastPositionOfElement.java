package com.training.leetcode;

public class FirstAndLastPositionOfElement {

    public int[] searchRange(int[] nums, int target) {

        int startIdx = searchFirst(nums, target);
        int endIdx = searchLast(nums, target);

        return new int[] {startIdx, endIdx};
    }

    public int searchFirst(int[] nums, int target) {

        int leftIdx = 0, rightIdx = nums.length - 1, targetIdx = -1;

        while(leftIdx <= rightIdx) {
            int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;

             if(target < nums[pivotIdx]) {
                rightIdx = pivotIdx - 1;
            } else if(target > nums[pivotIdx]){
                leftIdx = pivotIdx + 1;
            } else {
                 targetIdx = pivotIdx;
                 rightIdx = pivotIdx - 1;
             }
        }
        return targetIdx;

    }

    public int searchLast(int[] nums, int target) {

        int leftIdx = 0, rightIdx = nums.length - 1, targetIdx = -1;

        while(leftIdx <= rightIdx) {
            int pivotIdx = leftIdx + (rightIdx - leftIdx) / 2;

            if(target < nums[pivotIdx]) {
                rightIdx = pivotIdx - 1;
            } else if(target > nums[pivotIdx]){
                leftIdx = pivotIdx + 1;
            } else {
                targetIdx = pivotIdx;
                leftIdx = pivotIdx + 1;
            }
        }
        return targetIdx;
    }

    public static void main(String[] args) {
        System.out.println(new FirstAndLastPositionOfElement().searchRange(new int[] {5,7,7,8,8,10}, 8)[0]);
        StringBuilder sb = new StringBuilder();
        String s = "Marge, let's \"[went].\" I await {news} telegram.";
//        for(int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//
//            if(Character.isDigit(ch) || Character.isLetter(ch)) {
//
//                sb.append(Character.toLowerCase(ch));
//            }
//
//        }

        int left = 0, right = s.length() - 1;

        while(left < right) {
            boolean leftValid = Character.isDigit(s.charAt(left)) || Character.isLetter(s.charAt(left));
            boolean rightValid = Character.isDigit(s.charAt(right)) || Character.isLetter(s.charAt(right));
            if(!leftValid) {
                left++;
                continue;
            }
            if(!rightValid) {
                right--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                System.out.println(false);
                return;
            }
            left++; right--;
        }
        System.out.println(true);

        String columnTitle = "ZY";
        int lastIdx = columnTitle.length() - 1;
        int output = columnTitle.charAt(lastIdx) - 'A' + 1;

        int unit = 1;
        for(int i = lastIdx - 1; i >= 0; i--) {
            int denom = columnTitle.charAt(i) - 'A' + 1;
            output += Math.pow(26, unit) * denom;
            unit++;
        }

        System.out.println(output);
    }
}
