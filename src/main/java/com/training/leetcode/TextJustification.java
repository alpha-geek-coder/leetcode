package com.training.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>(0);
        int i = 0, n = words.length;

        while (i < n) {
            List<String> current_line = getWords(words, i, maxWidth);
            i += current_line.size();
            ans.add(createLine(words, current_line, i, maxWidth));
        }

        return ans;
    }
    public List<String> getWords(String[] words, int i, int maxWidth){
        List<String> current_line = new ArrayList<>();
        int len = 0;
        while (i < words.length && len + words[i].length() <= maxWidth) {
            current_line.add(words[i]);
            len += words[i].length() + 1;
            i++;
        }
        return current_line;
    }

    public String createLine(String[] words, List<String> current_line, int i, int maxWidth){
        int len = -1;
        for(String word : current_line){
            len += word.length() + 1;
        }
        int extra_spaces = maxWidth - len;
        if(current_line.size() == 1 || i == words.length){
            return String.join(" ", current_line) + new String(new char[extra_spaces]).replace("\0", " ").toString();
        }
        int word_count = current_line.size() - 1;
        int spaces_per_word = (int) Math.floor(extra_spaces / word_count);
        int need_extra_spaces = extra_spaces % word_count;

        for(int j = 0; j < need_extra_spaces; j++){
            current_line.set(j, current_line.get(j) + " ");
        }

        for(int j = 0; j < word_count; j++){
            current_line.set(j, current_line.get(j) + new String(new char[spaces_per_word]).replace("\0", " ").toString());
        }

        return String.join(" ", current_line);
    }

    public static void main(String[] args) {
        System.out.println(new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
