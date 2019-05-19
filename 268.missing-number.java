class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if(n == 0) {
        	return -1;
        }
        for(int i=0; i<n; i++) {
        	while(nums[i] != n && i != nums[i]) {
        		swap(nums, i, nums[i]);
        	}
        }
        for(int i=0; i<n; i++) {
        	if(i != nums[i]) {
        		return i;
        	}
        }
        return n;
    }
    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
