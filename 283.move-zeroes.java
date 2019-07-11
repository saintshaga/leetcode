class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
        	return;
        }
        int postionOfNonZero=0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] != 0) {
        		swap(nums, i, postionOfNonZero);
        		postionOfNonZero++;
        	}
        }

    }

    private void swap(int[] nums, int i, int j) {
    	if(i==j) {
    		return;
    	}
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
