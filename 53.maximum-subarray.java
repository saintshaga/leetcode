class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 0) {
        	return 0;
        }
        int max = nums[0];
        int[] c = new int[n];
        c[0] = nums[0];
        for(int i=1; i<n; i++) {
        	c[i] = Math.max(c[i-1]+nums[i], nums[i]);
        	if(max < c[i]) {
        		max = c[i];
        	}
        }
        return max;
    }
}
