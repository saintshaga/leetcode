class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
        	return nums.length;
        }
        int currentPos = 0;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] != nums[currentPos]) {
        		nums[++currentPos] = nums[i];
        	}
        }
        return currentPos+1;
    }
}
