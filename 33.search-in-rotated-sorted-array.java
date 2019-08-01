class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return -1;
        }
        int l=0, h=nums.length-1;
        while(l <= h) {
        	int mid = (l+h)/2;
        	if(nums[mid] == target) {
        		return mid;
        	}
        	if(nums[mid] >= nums[0]) {
        		if(target < nums[mid] && target >= nums[0]) {
        			h = mid -1;
        		} else {
        			l = mid + 1;
        		}
        	} else {
        		if(target > nums[mid] && target < nums[0]) {
        			l = mid + 1;
        		} else {
        			h = mid - 1;
        		}
        	}
        }
        return -1;
    }
}
