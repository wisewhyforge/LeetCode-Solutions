class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
            //System.out.println(queue.poll());
        }
        return queue.peek();
    }
}
