class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        if(n <= 1) {
        	return true;
        }
        int currentMax = -1, nextMax = 0;
        for(int i=0; i<n; i++) {
        	if(i > currentMax) {
        		currentMax = nextMax;
        	}
        	if(nums[i] + i >= n-1) {
        		return true;
        	}
        	nextMax = Math.max(nextMax,nums[i] + i);
        	if(i==currentMax && nextMax == currentMax) {
        		return false;
        	}
        }
        return false;
    }
}
