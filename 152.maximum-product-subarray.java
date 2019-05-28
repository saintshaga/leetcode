class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int n = nums.length;
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
        	result[i] = nums[i];
        	max = Math.max(max, result[i]);
        } 
        for(int distance = 1; distance <= n-1; distance++) {
        	for(int i=0; i<n-distance; i++) {
        		result[i] *= nums[i+distance];
        		max = Math.max(max, result[i]);
        	}
        }
        return max;
    }
}
