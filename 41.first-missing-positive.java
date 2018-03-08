class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] records = new boolean[n+1];
        for(int i=0; i<n; i++) {
        	if(nums[i] > 0 && nums[i] <= n+1) {
        		records[nums[i] - 1] = true;
        	}
        }
        for(int i=0; i<=n; i++) {
        	if(!records[i]) {
        		return i+1;
        	}
        }
        return 1;
    }
}
