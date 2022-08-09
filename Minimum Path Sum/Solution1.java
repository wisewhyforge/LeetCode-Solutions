class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return recur(grid, 0, 0, dp);
    }
    
    private int recur(int[][] grid, int i, int j, int[][] dp) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 10000;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            dp[i][j] = grid[i][j];
            return grid[i][j];
        }
        dp[i][j] = grid[i][j] + Math.min(recur(grid, i + 1, j, dp), recur(grid, i, j + 1, dp));
        return dp[i][j];
    }
}
