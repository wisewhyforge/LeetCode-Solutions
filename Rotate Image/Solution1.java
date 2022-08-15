class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        for (int i = n; i > 1; i -= 2) {
            int row = 0 + count;
            int col = 0 + count;
            for (int j = 1; j < i; j++) {
                int[] rotCoords = getRotRowCol(count, i, row, col);
                int temp = matrix[rotCoords[0]][rotCoords[1]];  
                int prev = matrix[row][col];
                
                for (int k = 0; k < 4; k++) {
                    matrix[rotCoords[0]][rotCoords[1]] = prev;
                    prev = temp;
                    row = rotCoords[0];
                    col = rotCoords[1];
                    rotCoords = getRotRowCol(count, i, row, col);
                    temp = matrix[rotCoords[0]][rotCoords[1]];
                }
                col++;
            }
            count++;
            
        }
    }
    //Row and col has to be on the edge of n
    private int[] getRotRowCol(int count, int currentLength, int row, int col) {
        row -= count;
        col -= count;
        return new int[]{col + count, currentLength - row - 1 + count};
        
    }
}
