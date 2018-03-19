class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 2) {
        	return;
        }
        int redIndex = 0, blueIndex = nums.length - 1;
        int i = 0;
        redIndex = i;
        while(i <= blueIndex) {
        	while((nums[i] == 0 && i != redIndex) || (nums[i] == 2 && i != blueIndex)) {
        		if(nums[i] == 0 && i != redIndex) {
        			swap(nums, i, redIndex++);
        		} else {
        			swap(nums, i, blueIndex--);
        		}
        	}
        	i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
    	if(i == j) {
    		return;
    	}
    	int t = nums[i];
    	nums[i] = nums[j];
    	nums[j] = t;
    }
}
