package com.training.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LeastFrequentUsedCache {
    // key = key and value = frequency-value pair
    Map<Integer, Pair<Integer, Integer>> cache;
    // key = freq and value = keys (sorted list)
    Map<Integer, LinkedHashSet<Integer>> freqs;
    int maxSize;
    int minFreq;
    public LeastFrequentUsedCache(int capacity) {
        maxSize = capacity;
        cache = new HashMap();
        freqs = new HashMap<>();
        minFreq = 0;
    }
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Pair<Integer, Integer> freqAndValue = cache.get(key);
        int freq = freqAndValue.getKey();
        int value = freqAndValue.getValue();
        Set<Integer> keys = freqs.get(key);
        keys.remove(key); // remove key since it's accessed now and freq of key increases by 1
        if(minFreq == freq && keys.isEmpty()){
            minFreq++;
        }
        // place this key in freq + 1 bucket
        insert(key, freq + 1, value);
        return value;
    }

    private void insert(int key, int freq, int value){
        cache.put(key, new Pair<>(freq, value));
        freqs.computeIfAbsent(freq, val -> new LinkedHashSet<Integer>()).add(key);
    }
    public void put(int key, int value) {
        if(maxSize <= 0) return;

        if(cache.containsKey(key)){
            cache.put(key, new Pair<>(cache.get(key).getKey(), value));
            get(key);
        } else {
            if (cache.size() == maxSize){
                Set<Integer> keys = freqs.get(minFreq);
                int keyToDelete = keys.iterator().next(); // lowest key for the freq.
                cache.remove(keyToDelete);
                keys.remove(keyToDelete);
            }
            minFreq = 1;
            insert(key, 1, value);
        }

    }
}
