package com.training.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int window = words.length * words[0].length();
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        if(window > n) return ans;

        Map<String, Integer> wordFreq = new HashMap<>();
        for(String word : words){
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

//        for(int i = 0; i < n - window  + 1; i++){
//            if(wordsCheck(s, wordFreq, words, i)){
//                ans.add(i);
//            }
//        }
        for(int i = 0; i < words[0].length(); i++){
            slidingWindow(s, i, ans, wordFreq, words);
        }
        return ans;
    }

    public void slidingWindow(String s, int left, List<Integer> ans, Map<String, Integer> wordFreq, String[] words){
        int n = s.length();
        int wordLength = words[0].length();
        int window = words.length * wordLength;
        int count = 0;
        boolean excessWord = false;
        Map<String, Integer> wordCount = new HashMap<>();
        for(int right = left; right <= n - wordLength; right += wordLength){
            String word = s.substring(right, right + wordLength);
            if(!wordFreq.containsKey(word)){
                wordCount.clear();
                count = 0;
                excessWord = false;
                left = right + wordLength;
            } else {
                while(right - left == window || excessWord){
                    String leftMostWord = s.substring(left, left + wordLength);
                    left += wordLength;
                    wordCount.put(leftMostWord, wordCount.get(leftMostWord) - 1);

                    if(wordCount.get(leftMostWord) >= wordFreq.get(leftMostWord)){
                        excessWord = false;
                    } else{
                        count--;
                    }
                }
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                if(wordCount.get(word) <= wordFreq.get(word)){
                    count++;
                } else {
                    excessWord = true;
                }

                if(count == words.length && !excessWord){
                    ans.add(left);
                }
            }

        }
    }

    public boolean wordsCheck(String s, Map<String, Integer> wordFreq, String[] words, int startIdx){

        int count  = 0;
        int wordLength = words[0].length();
        int window = words.length * words[0].length();
        Map<String, Integer> wordCount = new HashMap<>(wordFreq);
        for(int i = startIdx; i < startIdx + window; i+= wordLength){
            String word = s.substring(i, i + wordLength);
            if(wordCount.getOrDefault(word, 0) != 0){
                wordCount.put(word, wordCount.get(word) - 1);
                count++;
            } else {
                break;
            }
        }
        return count == words.length;
    }


    public static void main(String[] args) {
        System.out.println(new SubStringWithConcatenationOfAllWords().findSubstring("xybarfoofoobarthefoobarman", new String[]{"foo", "bar"}));
    }
}
