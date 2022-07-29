class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        if (isArithmetic(nums, 0, nums.length-1)) {
            return (nums.length - 2) * (nums.length - 1) / 2;
        }
        return recur(nums, nums.length);
    }
    
    private int recur(int[] nums, int length) {
        if (length <= 2) return 0;
        int ans = 0;
        for (int i = 0; i <= nums.length - length; i++) {
            if (isArithmetic(nums, i, i + length - 1)) {
                ans++;
            }
        }
        return ans + recur(nums, length - 1);
    }
    
    private boolean isArithmetic(int[] arr, int i, int j) {
        int diff = arr[i + 1] - arr[i];
        for (int index = i + 2; index <= j; index++) {
            int curDiff = arr[index] - arr[index - 1];
            if (curDiff != diff) {
                return false;
            }
        }
        return true;
    }
}
