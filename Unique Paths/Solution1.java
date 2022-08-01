class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(m, n, dp);
    }
    
    private int recur(int curWidth, int curHeight, int[][] dp) {
        if (dp[curWidth][curHeight] != -1) {
            return dp[curWidth][curHeight];
        }
        if (curHeight == 1 && curWidth == 1) {
            return 1;
        }
        
        int ans = 0;
        if (curHeight > 1) {
            ans += recur(curWidth, curHeight - 1, dp);
        } 
        
        if (curWidth > 1) {
            ans += recur(curWidth - 1, curHeight, dp);
        }
        
        dp[curWidth][curHeight] = ans;
        return ans;
    }
}
