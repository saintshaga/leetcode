class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) {
        	return nums.length;
        }
        int currentPos = 0, count = 1;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == nums[currentPos]) {
        		if(count < 2) {
        			nums[++currentPos] = nums[i];
        		}
       			count++;
        	} else {
        		nums[++currentPos] = nums[i];
        		count = 1;
        	}
        }
        return currentPos + 1;
    }
}
