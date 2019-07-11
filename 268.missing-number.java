class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        int n = nums.length;
        for(int i=0; i<nums.length; i++) {
        	while(nums[i] != n && nums[i] != i) {
        		swap(nums, i, nums[i]);
        	}
        }
        for(int i=0; i<nums.length; i++) {
        	if(i != nums[i]) {
        		return i;
        	}
        }
        return n;
    }

    private void swap(int[] nums, int i, int j) {
    	if(i == j) {
    		return;
    	}
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
