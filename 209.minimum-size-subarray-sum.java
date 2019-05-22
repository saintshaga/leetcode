class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int sum = 0, result = nums.length+1, left = 0;
        for(int i=0; i<nums.length; i++) {
        	sum += nums[i];
        	while(sum >= s) {
        		result = Math.min(result, i-left+1);
        		sum -= nums[left++];
        	}
        }
        return result > nums.length ? 0 : result;
    }
}
