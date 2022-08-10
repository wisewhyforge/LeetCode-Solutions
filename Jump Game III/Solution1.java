class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return recur(arr, start, visited);
    }
    
    private boolean recur(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }
        
        if (arr[start] == 0) {
            return true;
        }
        visited[start] = true;
        boolean res = recur(arr, start + arr[start], visited) || recur(arr, start - arr[start], visited);
        visited[start] = false;
        return res;
    }
}
