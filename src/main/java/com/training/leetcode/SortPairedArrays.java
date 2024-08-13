package com.training.leetcode;

import javafx.util.Pair;

import java.util.*;

public class SortPairedArrays {

    public static void sortPairedArrays(int[] arr1, int[] arr2){

        int m = arr1.length;
        Pair<Integer, Integer>[] pairs = new Pair[m];
        for(int i = 0; i < m; i++){
            pairs[i] = new Pair<Integer, Integer>(arr1[i], arr2[i]);
        }
        //Arrays.sort(pairs, (a, b) -> a.getKey().compareTo(b.getKey()));
        Arrays.sort(pairs, (a, b) -> a.getKey().intValue() == b.getKey().intValue() ? a.getValue().compareTo(b.getValue()) : a.getKey().compareTo(b.getKey()));

        for(int i = 0; i < m; i++){
            arr1[i] = pairs[i].getKey();
            arr2[i] = pairs[i].getValue();
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {3,2,3,1};
        int[] arr2 = {6,4,5,3};
        sortPairedArrays(arr1, arr2);
        for(int i = 0; i < arr1.length; i++){
            System.out.println(arr1[i] + "--> " + arr2[i]);
        }
        Map<Integer, List<Integer>> adjList = new HashMap();
        adjList.computeIfAbsent(0, val -> new ArrayList<Integer>()).add(1);
        adjList.computeIfAbsent(0, val -> new ArrayList<Integer>()).add(2);
        adjList.computeIfAbsent(1, val -> new ArrayList<Integer>()).add(0);

        for(List<Integer> value : adjList.values()){
            System.out.println(value);
        }
    }
}
