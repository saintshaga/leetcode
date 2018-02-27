class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
        	return 0;
        }
        int low = 0, high = nums.length-1, mid=0;
        while(low <= high) {
        	mid = (low+high)/2;
        	if(target == nums[mid]) {
        		return mid;
        	} else if(target > nums[mid]) {
        		low = mid + 1;
        	} else {
        		high = mid -1;
        	}
        }
        return target > nums[mid] ? (mid+1) : mid;
    }
}
