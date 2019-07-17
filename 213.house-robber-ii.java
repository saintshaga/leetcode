class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0) {
        	return 0;
        }
        int max = rob(nums, 0, nums.length-1);
        if(nums.length >= 2) {
	        max = Math.max(max, rob(nums, 1, nums.length));
        }
        return max;
    }

    private int rob(int[] nums, int st, int ed) {
        int[] c = new int[nums.length];
        c[st] = nums[st];
        int max = nums[st], max2 = 0;
        for(int i=st+1; i<ed; i++) {
        	c[i] = nums[i] + max2;
        	max = Math.max(max, c[i]);
        	if(i>=st+1) {
        		max2 = Math.max(max2, c[i-1]);
        	}
        }
        return max;
    }

}
