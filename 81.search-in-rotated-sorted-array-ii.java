class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return false;
        }
        int l=0, h=nums.length-1;
        while(l <= h) {
        	int mid = (l+h)/2;
        	if(nums[mid] == target) {
        		return true;
        	}
        	if(nums[mid] > nums[0]) {
        		if(target < nums[mid] && target >= nums[0]) {
        			h = mid -1;
        		} else {
        			l = mid + 1;
        		}
        	} else if(nums[mid] < nums[0]) {
        		if(target > nums[mid] && target < nums[0]) {
        			l = mid + 1;
        		} else {
        			h = mid - 1;
        		}
        	} else {
        		if(nums[l] == target) {
        			return true;
        		} else {
        			l++;
        		}
        	}
        }
        return false;

    }
}
