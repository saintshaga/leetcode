class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
        	return;
        }
        for(int p1 = 0, current = 0; current < nums.length; current++) {
        	if(nums[current] != 0) {
        		swap(nums, p1++, current);
        	}
        }
    }

    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
