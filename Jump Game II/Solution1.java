class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recur(nums, 0, dp);
    }
    
    private int recur(int[] nums, int index, int[] dp) {
        
        if (index >= nums.length) {
            return 10000;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        if (index == nums.length - 1) {
            return 0;
        }
        if (nums[index] == 0) {
            return 10000;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++) {
            
            ans = Math.min(ans, 1 + recur(nums, index + i, dp));
        }
        dp[index] = ans;
        return dp[index];
    }
}
