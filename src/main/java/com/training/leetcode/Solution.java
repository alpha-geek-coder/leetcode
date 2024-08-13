package com.training.leetcode;

public class Solution {

    public int reverseInteger(int x) {

        long reverse = 0;
        while(x != 0) {
            int lastDigit = x % 10;
            reverse = reverse * 10 + lastDigit;
            x /= 10;
        }

        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) return 0;

        return (int) reverse;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int[] merge = new int[nums1.length + nums2.length];
//
//        int p1 = 0, p2 = 0, p3 = 0; double median = 0.0;
//        int m = nums1.length, n = nums2.length, x = merge.length;
//        while(p3 < x) {
//            if(p1 < m && p2 < n) {
//                if(nums1[p1] <= nums2[p2]) {
//                    merge[p3++] = nums1[p1++];
//                } else {
//                    merge[p3++] = nums2[p2++];
//                }
//            } else if(p1 < m) {
//                merge[p3++] = nums1[p1++];
//            } else {
//                merge[p3++] = nums2[p2++];
//            }
//        }
//        if(x % 2 != 0) return (double) merge[x / 2];
//
//    return (double) (merge[(x - 1) / 2] + merge[x / 2]) / 2.0;
//        int x = nums1.length;
//        int y = nums2.length;
//        if(x > y) {
//            return findMedianSortedArrays(nums2, nums1);
//        }
//
//        int low = 0;
//        int high = x;
//
//        while(low <= high) {
//
//            int partitionX = (low + high) / 2;
//            int partitionY = ((x + y + 1) / 2) - partitionX;
//
//            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
//            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
//
//            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
//            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
//
//
//            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
//                if((x + y) % 2 == 0) {
//                    return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
//                }else {
//                    return (double) Math.max(maxLeftX, maxLeftY);
//                }
//            } else if(maxLeftX > minRightY) {
//                high = partitionX - 1;
//            } else {
//                low = partitionX + 1;
//            }
//        }

        int x = nums1.length;
        int y = nums2.length;

        if(x > y) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int leftX = 0, rightX = x;

        while(leftX <= rightX) {
            int partitionX = (leftX + rightX) / 2;

            int partitionY = ((x + y + 1) / 2) - partitionX;

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if((x+y) % 2 == 0) {
                    return (double) (Math.max(maxLeftX, maxLeftY)
                            + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY) ;
                }
            } else if(maxLeftX > minRightY) {
                rightX = partitionX - 1;
            } else {
                leftX = partitionX + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Merge Two Sorted Array");
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        System.out.println("Median is -> " + sol.findMedianSortedArrays(nums1, nums2));
        System.out.println("-----------------------------------");
        System.out.println("Reverse Integer");
        System.out.println("123 -> " + sol.reverseInteger(123));
        System.out.println("1534236469 -> " + sol.reverseInteger(1534236469));
        System.out.println(Integer.MIN_VALUE + " -> " + sol.reverseInteger(Integer.MIN_VALUE));
        System.out.println(Integer.MAX_VALUE + " -> " + sol.reverseInteger(Integer.MAX_VALUE));


    }
}
