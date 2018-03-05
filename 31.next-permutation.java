class Solution {
    public void nextPermutation(int[] nums) {
    	int n = nums.length;
    	if(n == 0) {
    		return;
    	}

    	int i = n - 1;
    	while(i >= 1 &&  nums[i-1] >= nums[i]) {
    		i--;
    	}
        reverse(nums, i, n-1);
        if(i >= 1) {
        	int j = i-1;
        	while(nums[i] <= nums[j] && i < n) {
        		i++;
        	}
        	swap(nums, j,Math.min(i,n-1));
        }
    }

    private void swap(int[] nums, int i, int j) {
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
    	while(i < j) {
    		swap(nums, i++, j--);
    	}
    }
}
