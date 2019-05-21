class Solution {
    public int majorityElement(int[] nums) {
    	int candidate = nums[0], count = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(count == 0) {
    			candidate = nums[i];
    		}
    		count += candidate == nums[i] ? 1 : -1;
    	}
    	return candidate;
    }
}
