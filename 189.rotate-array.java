class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k%(nums.length) == 0) {
        	return;
        }
        k = k % (nums.length);
        flip(nums, 0, nums.length-k-1);
        flip(nums, nums.length-k, nums.length-1);
        flip(nums, 0, nums.length-1);
    }

    private void flip(int[] nums, int start, int endInclusive) {
    	for(int i=start; i<=(start+endInclusive)/2; i++) {
    		swap(nums, i, start+endInclusive-i);
    	}
    }

    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}
