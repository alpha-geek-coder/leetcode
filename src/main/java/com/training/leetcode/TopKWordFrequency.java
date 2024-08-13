package com.training.leetcode;

import java.util.*;

public class TopKWordFrequency {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFreq = new HashMap();

        for(String word : words){
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue().compareTo(b.getValue())
        );


        for(Map.Entry<String, Integer> entry : wordFreq.entrySet()){
            pq.add(entry);
            if(pq.size() > k) pq.poll();
        }

        LinkedList<String> result = new LinkedList();
        while(!pq.isEmpty()){
            result.addFirst(pq.poll().getKey());
        }
        Random random = new Random();
        int index = random.nextInt(5);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new TopKWordFrequency().topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 3));
        System.out.println(new TopKWordFrequency().topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }

}
