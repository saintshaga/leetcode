class Solution {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> results = new ArrayList<>();
        if(nums == null || nums.length == 0) {
        	return results;
        }
        int candidate1 = nums[0], candidate2 = nums[0];
        int count1 = 0, count2 = 0;
        for(int i=0; i<nums.length; i++) {
        	if(count1 != 0 && candidate1 == nums[i]) {
        		count1++;
        	} else if(count2 != 0 && candidate2 == nums[i]) {
        		count2++;
        	} else if(count1 == 0) {
        		count1 = 1;
        		candidate1 = nums[i];
        	} else if(count2 == 0) {
        		count2 = 1;
        		candidate2 = nums[i];
        	} else {
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.length; i++) {
        	if(candidate1 == nums[i]) {
        		count1++;
        	} else if(candidate2 == nums[i]) {
        		count2++;
        	}
        }
        if(count1 > nums.length/3) {
        	results.add(candidate1);
        }
        if(count2 > nums.length/3) {
        	results.add(candidate2);
        }
        return results;
    }
}
