class Solution {
    public boolean isPowerOfFour(int n) {
        return recur(n);
    }
    
    private boolean recur(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (n % 4 != 0) {
            return false;
        }
        
        return recur(n / 4);
    }
}
