class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int[] c = new int[nums.length];
        int max = nums[0];
        int max2 = 0;
        c[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
        	if(i >= 2) {
        		max2 = Math.max(max2, c[i-2]);
        	}
        	c[i] = nums[i] + max2;
        	max = Math.max(max, c[i]);
        }
        return max;
    }
}
