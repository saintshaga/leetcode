class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
        	return 0;
        }
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for(int i=0; i<nums.length; i++) {
        	if(i+nums[i] >= nums.length-1) {
        		return steps[i] + 1;
        	}
        	for(int j=i+nums[i]; (j>i && steps[j] == 0); j--) {
        		steps[j] = steps[i] + 1;
        	}
        }
        return steps[nums.length-1];
    }
}
