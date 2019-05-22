class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return Collections.emptyList();
        }
        List<String> results = new ArrayList<>();
        int startIndex = 0;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] - nums[startIndex] != i - startIndex) {
        		int endIndex = i-1;
        		results.add(generateResult(nums, startIndex, endIndex));
        		startIndex = i;
        	}
        }
        results.add(generateResult(nums, startIndex, nums.length-1));
        return results;
    }

    private String generateResult(int[] nums, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
        	return String.valueOf(nums[startIndex]);
        } else {
        	return "" + nums[startIndex] + "->" + nums[endIndex];
        }
    }
}
