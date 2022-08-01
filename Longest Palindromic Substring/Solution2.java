class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }        
        
        String[][] dp = new String[s.length()][s.length()];
        
        return recur(s, 0, s.length() - 1, dp);
    }
    
    private String recur(String str, int start, int end, String[][] dp) {
        if (dp[start][end] != null) return dp[start][end];
        if (start > end) {
            return null;
        }
        if (start == end) {
            dp[start][end] = str.charAt(start) + "";
            return dp[start][end];
        }
        if (isPalindrome(str, start, end)) {
            dp[start][end] = str.substring(start, end + 1);
            return dp[start][end];
        }
        
        String res1 = recur(str, start, end - 1, dp);
        String res2 = recur(str, start + 1, end, dp);
        
        if (res1 == null && res2 == null) {
            dp[start][end] = str.charAt(0) + "";
            return dp[start][end];
        }
        
        if (res1 == null) {
            dp[start][end] = res2;
            return res2;
        }
        
        if (res2 == null) {
            dp[start][end] = res1;
            return res1;
        }
        dp[start][end] = res1.length() > res2.length() ? res1 : res2;
        return dp[start][end];
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return false;
        
        }
        if (start == end) {
            return true;
        }
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}
