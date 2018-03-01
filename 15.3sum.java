class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        if(nums.length < 3) {
        	return results;
        }
        for(int i=0; i<nums.length-2; i++) {
        	if(i > 0 && nums[i] == nums[i-1]) {
        		continue;
        	}
        	int sum = -1 * nums[i];
        	int lowj = i+1, highj = nums.length-1;
        	while(lowj < highj) {
        		if(nums[lowj] + nums[highj] > sum) {
        			highj--;
        		} else if(nums[lowj] + nums[highj] < sum) {
        			lowj++;
        		} else {
		        	List<Integer> result = new ArrayList<>();
        			result.add(nums[i]);
        			result.add(nums[lowj]);
        			result.add(nums[highj]);
        			results.add(result);
        			lowj++;highj--;
        			while(lowj < highj && result.get(1) == nums[lowj] && result.get(2) == nums[highj]) {
        				lowj++;
        				highj--;
        			}
        		}
        	}
        }
        return results;
    }
}
