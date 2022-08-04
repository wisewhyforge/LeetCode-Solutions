class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        } 
        return recur(obstacleGrid, 0, 0, dp);
    }
    
    private int recur(int[][] obstacleGrid, int i, int j, int[][] dp) {
        if (i >= obstacleGrid.length) {
            return 0;
        }
        if (j >= obstacleGrid[i].length) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[i].length - 1) {
            return 1;
        }
        int height = obstacleGrid.length - i;
        int width = obstacleGrid[i].length - j;
        if (dp[height][width] != -1) {
            return dp[height][width];
        }
        
        dp[height][width] = recur(obstacleGrid, i + 1, j, dp) + recur(obstacleGrid, i, j + 1, dp);
        return dp[height][width];
    }
}
