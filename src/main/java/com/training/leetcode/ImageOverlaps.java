package com.training.leetcode;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlaps {

    // Approach 1 : Brute force
    public int largestOverlap(int[][] img1, int[][] img2) {

        int maxOverlaps = 0;

        for(int yShift = 0; yShift < img1.length; yShift++){
            for(int xShift = 0; xShift < img1[0].length; xShift++){
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, img1, img2));
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, img2, img1));
            }
        }
        return maxOverlaps;

    }
    //Approach 2 : Using Linear Transformation
    public int largestOverlapLinearTransformation(int[][] img1, int[][] img2){
        List<Pair<Integer, Integer>> pairs1 = new ArrayList<>();
        List<Pair<Integer, Integer>> pairs2 = new ArrayList<>();
        for(int r = 0; r < img1.length; r++){
            for(int c = 0; c < img1[0].length; c++){
                if(img1[r][c] == 1){
                    pairs1.add(new Pair(r,c));
                }
                if(img2[r][c] == 1){
                    pairs2.add(new Pair(r,c));
                }
            }
        }
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int ans = 0;
        for(Pair<Integer, Integer> pair1 : pairs1){
            for(Pair<Integer, Integer> pair2 : pairs2){
                int x = pair2.getValue() - pair1.getValue() ;
                int y = pair2.getKey() - pair1.getKey();
                map.put(new Pair(x, y), map.getOrDefault(new Pair(x,y), 0) + 1);
                ans = Math.max(ans, map.get(new Pair(x,y)));
            }
        }
        return ans;
    }
    //Approach 3 : Using image convolution
    public int largestOverlapImageConvolution(int[][] img1, int[][] img2){

        int n = img2.length;
        int img2Resize = n + (2 * (n - 1));
        int[][] img2Kernels = new int[img2Resize][img2Resize];

        // Build img2Kernels
        for(int r = 0; r < img2.length; r++){
            for(int c = 0; c < img2[0].length; c++){
                img2Kernels[r + n - 1][c + n - 1] = img2[r][c];
            }
        }

        int maxOverlaps = 0;
        for(int xShift = 0; xShift < 2 * n - 1; xShift++){
            for(int yShift = 0; yShift < 2 * n - 1; yShift++){
                maxOverlaps = Math.max(maxOverlaps, convolute(img1, img2Kernels, xShift, yShift));
            }
        }
        return maxOverlaps;
    }

    public int convolute(int[][] img1, int[][] img2Kernels, int xShift, int yShift){
        int overlaps = 0;
        for(int r = 0; r < img1.length; r++){
            for(int c = 0; c < img1[0].length; c++){
                overlaps += img1[r][c] * img2Kernels[r + yShift][c + xShift];
            }
        }

        return overlaps;
    }
    public int shiftAndCount(int xShift, int yShift, int[][] shiftImg, int[][] refImg){
        int leftShiftCount = 0, rightShiftCount = 0;

        int refImgRow = 0;
        for(int shiftImgRow = yShift; shiftImgRow < shiftImg.length; shiftImgRow++){
            int refImgCol = 0;
            for(int shiftImgCol = xShift; shiftImgCol < shiftImg[0].length; shiftImgCol++){
                if(shiftImg[shiftImgRow][shiftImgCol] == 1 && shiftImg[shiftImgRow][shiftImgCol] == refImg[refImgRow][refImgCol]){
                    leftShiftCount++;
                }
                if(shiftImg[shiftImgRow][refImgCol] == 1 && shiftImg[shiftImgRow][refImgCol] == refImg[refImgRow][shiftImgCol]){
                    rightShiftCount++;
                }
                refImgCol++;
            }
            refImgRow++;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public static void main(String[] args) {
        System.out.println(new ImageOverlaps().largestOverlap(new int[][]{
                {1,1,0},
                {0,1,0},
                {0,1,0}
        }, new int[][]{
                {0,0,0},
                {0,1,1},
                {0,0,1}
        }));

        System.out.println(new ImageOverlaps().largestOverlapLinearTransformation(new int[][]{
                {1,1,0},
                {0,1,0},
                {0,1,0}
        }, new int[][]{
                {0,0,0},
                {0,1,1},
                {0,0,1}
        }));

        char hex[]={
                '0','1','2','3','4','5',
                '6','7','8','9','a','b','c',
                'd','e','f'
        };

        byte b=(byte) 0x0f1;

        byte b1 = (byte) 0x0f;
        int b2 = (b>>4) & 0x0f;
        System.out.println("b = 0x" + hex [(b>>4) & 0x0f] + hex[b & 0x0f]);


        long ans = 0;
        for(int i = 0; i <= 30; i++){
            ans += Math.pow(2, i);
        }
        System.out.println(ans);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((Integer.toBinaryString(Integer.MAX_VALUE)));
        System.out.println(Integer.MIN_VALUE);
        System.out.println((Integer.toBinaryString(Integer.MIN_VALUE)));
        System.out.println((Integer.toBinaryString(-1)));
    }
}
