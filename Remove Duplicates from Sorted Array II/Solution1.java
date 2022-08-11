class Solution {
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        int curNum = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (curNum == nums[i]) {
                count++;
                if (count < 3) {
                    nums[insertIndex] = curNum;
                    insertIndex++;
                }
            } else {
                curNum = nums[i];
                count = 1;
                nums[insertIndex] = curNum;
                insertIndex++;
            }
            
        }
        return insertIndex;
    }
}
