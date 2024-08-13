package com.training.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(String email : emails){
            boolean domain = false, skip = false;
            sb.setLength(0);
            for(int i = 0; i < email.length(); i++){
                char c = email.charAt(i);
                if(c == '@') {
                    domain = true;
                    sb.append(c);
                } else if(c == '+' && !domain) {
                    skip = true;
                } else if(c != '.' && !domain && !skip){
                    sb.append(c);
                } else if(domain){
                    sb.append(c);
                }
            }
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmails().numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
