package com.training.leetcode;

public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[][] memo = new int[n][shelfWidth + 1];

        return dp( books, memo, shelfWidth, shelfWidth, 0, 0);
       
    }

    public int dp(int[][] books, int[][] memo, int shelf_width, int remaning_shelf_width, int idx, int max_height ){
        
        int[] curr_book = books[idx];
        int curr_width = curr_book[0], curr_height = curr_book[1];
        int max_height_updated = Math.max(max_height, curr_height);

        if(idx == books.length - 1) {
            if(remaning_shelf_width >= curr_width){
                return max_height_updated;
            } 
            return max_height + curr_height;
        } 

        if(memo[idx][remaning_shelf_width] != 0){
            return memo[idx][remaning_shelf_width];
        }

        // option 1 : if curr book cannot fit in curr shelf, place it in new shelf  
        int option_1_height = max_height + dp(books, memo, shelf_width, shelf_width - curr_width, idx + 1, curr_height);
        
        // option 2 : place curr book in curr shelf
        if(remaning_shelf_width >= curr_width){
            int option_2_height = dp(books, memo, shelf_width, remaning_shelf_width - curr_width, idx + 1, max_height_updated);
            memo[idx][remaning_shelf_width] = Math.min(option_1_height, option_2_height);
            return memo[idx][remaning_shelf_width];
        } 
        
        memo[idx][remaning_shelf_width] = option_1_height;
            
        return memo[idx][remaning_shelf_width];

    }

    public static void main(String[] args) {
        System.out.println(new FillingBookcaseShelves().minHeightShelves(new int[][] {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));

        String s = "7868190130M7522";
        int age = Integer.parseInt(s.substring(11, 13));
        System.out.println(age);
    }
}
