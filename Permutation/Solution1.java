class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void backtrack(int[] nums, int start, ArrayList<Integer> cur, ArrayList<List<Integer>> ans) {
        
        if (cur.size() == nums.length) {
            //System.out.println(cur);
            ans.add((ArrayList<Integer>)cur.clone());
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                backtrack(nums, i + 1, cur, ans);
                cur.remove((Object) nums[i]);
            }
        }
    }
}
