class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) {
        	return;
        }
        int p1 = 0;
        while(p1 < nums.length && nums[p1] != 0) {
        	p1++;
        }
        int p2 = p1+1;
        while(p1 < nums.length) {
    	    while(p2 < nums.length && nums[p2] == 0) {
    	    	p2++;
    	    }
    	    if(p2 == nums.length) {
    	    	return;
    	    }
    	    swap(nums, p1, p2);
    	    p1++;
    	    p2++;
        }
    }

    private void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
