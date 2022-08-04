class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[start] == target) {
                return start;
            }
            if (nums[end - 1] == target) {
                return end - 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= nums[end - 1] && nums[mid] >= nums[start]) {
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            } else {
                if (nums[mid] > nums[start]) {
                    if (within(target, nums[start], nums[mid])) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (within(target, nums[mid], nums[end - 1])) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean within(int target, int start, int end) {
        return target <= end && target >= start;
    }
}
