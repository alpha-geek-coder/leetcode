
package com.training.leetcode;
public class ArrayStringAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//
//
//        for(String word : word1){
//            sb1.append(word);
//        }
//
//        for(String word : word2){
//            sb2.append(word);
//        }
//
//        return sb1.toString().equals(sb2.toString());

        CharacterIterator i1 = new CharacterIterator(word1);
        CharacterIterator i2 = new CharacterIterator(word2);

        while(i1.hasNext() && i2.hasNext()){

            char c1 = i1.hasNext() ? i1.getNext() : '0';
            char c2 = i2.hasNext() ? i2.getNext() : '0';
            if(c1 != c2) return false;
        }
        return !i1.hasNext() && !i2.hasNext();
    }

    static class CharacterIterator{
        String[] words;
        int wordIdx;
        int charIdx;

        CharacterIterator(String[] words){
            this.words = words;
            wordIdx = 0;
            charIdx = 0;
        }

        public boolean hasNext(){
            return wordIdx < words.length && charIdx < words[wordIdx].length();
        }

        public char getNext(){
            char c = words[wordIdx].charAt(charIdx++);
            if(charIdx == words[wordIdx].length()){
                charIdx = 0;
                wordIdx++;
            }
            return c;
        }
    }

    public static void main(String[] args) {

        System.out.println(new ArrayStringAreEqual().arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}
