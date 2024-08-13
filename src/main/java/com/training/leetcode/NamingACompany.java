package com.training.leetcode;

import java.util.HashSet;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        // Array of HashSet for intial a-z containing suffix of idea string 2nd char till end
        HashSet<String>[] initialsGroup = new HashSet[26];

        for(int i = 0; i < 26; i++){
            initialsGroup[i] = new HashSet<>();
        }
        for(String idea : ideas){
            char intial = idea.charAt(0);
            int group = intial - 'a';
            // add idea 2nd char till end to intials group
            initialsGroup[group].add(idea.substring(1));
        }
        long ans = 0;
        for(int i = 0; i < 25; i++){

            for(int j = i+ 1; j < 26; j++){
                long numOfMutual = 0;
                for(String ideaA : initialsGroup[i]){
                    if(initialsGroup[j].contains(ideaA)){
                        numOfMutual++;
                    }
                }
                ans += 2 * (initialsGroup[i].size() - numOfMutual) * (initialsGroup[j].size() - numOfMutual);
            }
        }
        return  ans;
    }
}
