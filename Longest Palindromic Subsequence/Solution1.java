class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return recur(s, 0, s.length() - 1, dp);    
    }
    
    private int recur(String str, int start, int end, int[][] dp) {
        if (dp[start][end] != 0) return dp[start][end];
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if (start > end) {
            return 0;
        }
        if (str.charAt(start) == str.charAt(end)) {
            dp[start][end] = 2 + recur(str, start + 1, end - 1, dp);
            return dp[start][end];
        }
        else {
            dp[start][end] = Math.max(recur(str, start + 1, end, dp), recur(str, start, end - 1, dp));
            return dp[start][end];
        }
    }
}
