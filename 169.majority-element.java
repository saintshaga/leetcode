class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
        	return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
        	int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
        	map.put(nums[i], ++count);
        	if(count > nums.length/2) {
        		return nums[i];
        	}
        }
        return -1;
    }
}
