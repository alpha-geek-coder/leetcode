package com.training.leetcode;

import java.util.*;

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        int lastIdx = list.size() - 1;
        map.remove(val);
        if(idx == lastIdx){
            list.remove(lastIdx);
        } else {
            list.set(idx, list.get(lastIdx));
            map.put(list.get(idx), idx);
            list.remove(lastIdx);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(0));
        System.out.println(set.insert(2));
        System.out.println(set.insert(1));
        System.out.println(set.insert(1));
        System.out.println(set.insert(1));
        System.out.println(set.remove(0));
        System.out.println(set.insert(0));
        System.out.println(set.getRandom());

        String word1 = "cabbba", word2 = "abbccc";

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i = 0; i < word1.length(); i++) arr1[word1.charAt(i) - 'a']++;
        for(int i = 0; i < word2.length(); i++) arr2[word2.charAt(i) - 'a']++;

        for(int i = 0; i < 26; i++){
            if((arr1[i] == 0 && arr2[i] > 0)|| arr1[i] > 0 && arr2[i] == 0) {
                System.out.println("mismatch");
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < 26; i++){
            if(arr1[i] != arr2[i]){
                System.out.println("fail");
            }
        }

        System.out.println("pass");

    }
}
