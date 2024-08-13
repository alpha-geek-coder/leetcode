package com.training.leetcode;

import java.util.Arrays;

public class SortArrayByOrderOfAnotherArray {

    public static void sortArrays(int[] arr1, int[] arr2){
        int m = arr1.length, n = arr2.length;

        int[] tmp = Arrays.copyOf(arr1, m);
        int[] visited = new int[m];
        Arrays.sort(tmp);
        int idx = 0;
        for(int i = 0; i < n; i++){
            int seq = arr2[i];
            int pos = binarySearch(tmp, seq);
            if(pos == -1) continue;
            for(int j = pos; j < m && tmp[j] == seq; j++){
                arr1[idx++] = seq;
                visited[j] = 1;
            }
        }

        for(int i = 0; i < m; i++){
            if(visited[i] == 0){
                arr1[idx++] = tmp[i];
            }
        }


    }

    public static int binarySearch(int[] tmp, int num){
        int l = 0, h = tmp.length - 1, idx = -1;

        while(l <= h){
            int mid = l + (h - l) / 2;
            if(tmp[mid] == num) {
                idx = mid;
                h = mid - 1;
            } else if(tmp[mid] < num){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String args[])
    {
        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
        int A2[] = { 2, 1, 8, 3 };
        int m = A1.length;
        System.out.println("Sorted array is ");
        sortArrays(A1, A2);
        for (int i = 0; i < m; i++)
            System.out.print(A1[i] + " ");
        System.out.println();
    }
}
