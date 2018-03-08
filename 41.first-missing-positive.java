class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
        	while(nums[i] > 0 && nums[i] <= n && nums[i] != i+1) {
        		if(!swap(nums, i, nums[i]-1)) {
        			break;
        		}
        	}
        }
        for(int i=0; i<n; i++) {
        	if(nums[i] != i+1) {
        		return i+1;
        	}
        }
        return n+1;
    }

    private boolean swap(int[] nums, int i, int j) {
    	if(nums[i] == nums[j]) {
    		return false;
    	}
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    	return true;
    }
}
