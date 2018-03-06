class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mini = -1, maxi = -1;
        if(nums.length == 0) {
        	return new int[]{mini, maxi};
        }
        int l=0,h=nums.length-1;
        while(l <= h) {
        	int mid = (l+h)/2;
        	if(target == nums[mid]) {
        		mini = mid;
        		maxi = mid;
        		h = mid -1;
        	} else if(target < nums[mid]) {
        		h = mid - 1;
        	} else if(target > nums[mid]) {
        		l = mid + 1;
        	}
        }
        if(mini == -1) {
        	return new int[]{mini, maxi};
        }
        l = maxi;
        h = nums.length-1;
        while(l <= h) {
        	int mid = (l+h)/2;
        	if(target == nums[mid]) {
        		maxi = mid;
        		l = mid + 1;
        	} else if(target < nums[mid]) {
        		h = mid -1;
        	} else {
        		l = mid + 1;
        	}
        }
        return new int[]{mini, maxi};
    }
}
