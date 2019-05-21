class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return Collections.emptyList();
        }
        if(nums.length < 2) {
        	return IntStream.of(nums).boxed().collect(Collectors.toList());
        }
        int candidate1 = nums[0], candidate2 = nums[1];
        int count1 = 0, count2 = 0;
        for(int i=0; i<nums.length; i++) {
        	if(count1 == 0 && count2 == 0) {
        		candidate1 = nums[i];
        		count1 = 1;
        	} else if(count1 != 0 && count2 == 0) {
        		if(candidate1 == nums[i]) {
        			count1 += 1;
        		} else {
	        		candidate2 = nums[i];
    	    		count2 = 1;
        		}
        	} else if(count1 == 0 && count2 != 0) {
        		if(candidate2 == nums[i]) {
        			count2 += 1;
        		} else {
        			candidate1 = nums[i];
        			count1 = 1;
        		}
        	} else if(candidate1 == nums[i]) {
        		count1++;
        	} else if(candidate2 == nums[i]) {
        		count2++;
        	} else {
        		count1--;
        		count2--;
        	}
        }
        List<Integer> results = new ArrayList<>(2);
        if(count1 > 0 && exceedNumber(nums, candidate1)) {
        	results.add(candidate1);
        }
        if(count2 > 0 && exceedNumber(nums, candidate2)) {
        	results.add(candidate2);
        }
        return results;
    }

    private boolean exceedNumber(int[] nums, int candidate) {
    	int threshold = nums.length/3 + 1;
    	int count = 0;
    	for(int i=0; i < nums.length; i++) {
    		count += candidate == nums[i] ? 1 : 0;
    	}
    	return count >= threshold;
    }
}
