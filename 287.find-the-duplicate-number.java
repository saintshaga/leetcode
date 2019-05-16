class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length <= 1) {
        	return -1;
        }
        int n = nums.length - 1;
        for(int i=0; i<n; i++) {
        	for(int j=i+1; j<n+1; j++) {
        		if(nums[i] == nums[j]) {
        			return nums[i];
        		}
        	}
        }
        return -1;
    }
}
