class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) {
        	return false;
        }
        int l = 0, h = nums.length-1;
        while(l <= h) {
        	int mid = (l+h)/2;
        	if(target == nums[mid] || target == nums[l]) {
        		return true;
        	} else if(nums[mid] > nums[l]) {
        		if(target > nums[l] && target < nums[mid]) {
        			h = mid - 1;
        		} else {
        			l = mid + 1;
        		}
        	} else if(nums[mid] < nums[l]) {
        		if(target < nums[l] && target > nums[mid]) {
        			l = mid+1;
        		} else {
        			h = mid - 1;
        		}
        	} else {
        		l++;
        	}
        }
        return false;
    }
}
