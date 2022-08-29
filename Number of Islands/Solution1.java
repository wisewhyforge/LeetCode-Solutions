class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        ans++;
                        fill(grid, visited, i, j);
                    }
                }
            }
        }
        
        return ans;
    }
    
    private void fill(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = true;
        fill(grid, visited, i + 1, j);
        fill(grid, visited, i, j + 1);
        fill(grid, visited, i - 1, j);
        fill(grid, visited, i, j - 1);

    }
}
