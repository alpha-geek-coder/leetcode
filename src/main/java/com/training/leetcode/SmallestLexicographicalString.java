package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SmallestLexicographicalString {
    int minChar;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        Integer[][] adjMatrix = new Integer[26][26];

        for(int i = 0 ; i < s1.length(); i++){
            adjMatrix[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
            adjMatrix[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = 1;
        }

        int[] mappingChar = new int[26];
        for(int c = 0; c < 26; c++){
            mappingChar[c] = c;
        }
        Integer[] visited = new Integer[26];
        for(int c = 0; c < 26; c++){
            if(visited[c] == null){
                minChar = 27;
                List<Integer> component = new ArrayList<>();
                dfs(c, adjMatrix, visited, component);
                for(int ch : component){
                    mappingChar[ch] = minChar;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            sb.append(mappingChar[baseStr.charAt(i) - 'a'] + 'a');
        }
        return sb.toString();
    }

    public void dfs(int c, Integer[][] adjMatrix, Integer[] visited, List<Integer> component){
        visited[c] = 1;

        component.add(c);

        minChar = Math.min(minChar, c);

        for(int i = 0; i < 26; i++){
            if(adjMatrix[c][i] != null && visited[i] == null){
                dfs(c, adjMatrix, visited, component);
            }
        }
    }
}
