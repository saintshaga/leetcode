class Solution {
    public int findDuplicate(int[] nums) {
    	if(nums == null || nums.length <= 1) {
    		return -1;
    	}
    	int rabbit = 0, turtle = 0;
    	do {
    		rabbit = nums[rabbit];
    		turtle = nums[nums[turtle]];
    	} while(nums[rabbit] != nums[turtle]);
    	rabbit = 0;
    	while(nums[rabbit] != nums[turtle]) {
    		rabbit = nums[rabbit];
    		turtle = nums[turtle];
    	}
    	return nums[rabbit];
    }
}
