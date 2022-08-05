class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            int ans = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    ans += dp[i - nums[j]];
                }
            }
            dp[i] = ans;
        }
        return dp[target];
    }
    
    private int recur(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (map.get(target) != null) {
            return map.get(target);
        }
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            //System.out.println(i + " " + target);
            ans += recur(nums, target - nums[i], map);
        }
        map.put(target, ans);
        return ans;
    }
}
