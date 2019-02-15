class Solution {
    public int lengthOfLIS(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
        int[] length = new int[nums.length];
        int maxLength = 1;
        length[0] = 1;
        for(int i=1; i<nums.length; i++) {
        	length[i] = 1;
        	for(int j=0; j<i; j++) {
        		int currentLen = nums[j] < nums[i] ? length[j] + 1 : 0;
        		length[i] = currentLen > length[i] ? currentLen : length[i];
        	}
        	maxLength = maxLength < length[i] ? length[i] : maxLength;
        }
        return maxLength;
    }
}
