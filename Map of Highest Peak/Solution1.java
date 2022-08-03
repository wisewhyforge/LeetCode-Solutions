class Solution {
    
    private static class Coord {
        int row;
        int col;
        
        public Coord(int i, int j) {
            row = i;
            col = j;
        }
        
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
    
    public int[][] highestPeak(int[][] isWater) {
        int[][] ans = new int[isWater.length][isWater[0].length];
        Queue<Coord> queue = new LinkedList<Coord>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                ans[i][j] = -1;
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    queue.add(new Coord(i, j));
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                Coord c = queue.poll();
                int num = ans[c.row][c.col];
                if (c.row >= 1) {
                    if (ans[c.row - 1][c.col] == -1) {
                        ans[c.row - 1][c.col] = num + 1;
                        queue.add(new Coord(c.row - 1, c.col));
                    } 
                }
                if (c.col >= 1) {
                    if (ans[c.row][c.col - 1] == -1) {
                        ans[c.row][c.col - 1] = num + 1;
                        queue.add(new Coord(c.row, c.col - 1));
                    } 
                } 
                if (c.row < isWater.length - 1) {
                    if (ans[c.row + 1][c.col] == -1) {
                        ans[c.row + 1][c.col] = num + 1;
                        queue.add(new Coord(c.row + 1, c.col));
                    }
                } 
                if (c.col < isWater[c.row].length - 1) {
                    if (ans[c.row][c.col + 1] == -1) {
                        ans[c.row][c.col + 1] = num + 1;
                        queue.add(new Coord(c.row, c.col + 1));
                    }
                }
            }
            
            //System.out.println(queue);
        }
        
        return ans;
    }
}
