class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	if(nums.length < 3) {
    		throw new RuntimeException("Not enough numbers.");
    	}

    	Arrays.sort(nums);
    	int result = nums[0] + nums[1] + nums[2];
    	for(int i=0; i<nums.length-2; i++) {
    		int closestTo = target - nums[i];
    		int low = i+1, high = nums.length-1;
    		int closestSum = nums[low] + nums[high];
    		while(low < high) {
    			int twoSum = nums[low] + nums[high];
    			if(Math.abs(twoSum-closestTo) < Math.abs(closestSum-closestTo)) {
    				closestSum = twoSum;
    			}
    			if(twoSum == closestTo) {
    				return twoSum + nums[i];
    			} else if(twoSum < closestTo) {
    				low++;
    			} else if(twoSum > closestTo) {
    				high--;
    			}
    		}
    		if(Math.abs(result-target) > Math.abs(closestSum + nums[i]-target)) {
    			result = closestSum + nums[i];
    		}
    	}
    	return result;
    }
}
