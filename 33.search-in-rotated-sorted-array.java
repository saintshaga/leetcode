class Solution {
    public int search(int[] nums, int target) {
    	int n = nums.length;
    	if(n == 0) {
    		return -1;
    	}
    	int l=0,h=n-1;
    	while(l < h) {
    		int mid = (l+h)/2;
    		if(nums[mid] == target) {
    			return mid;
    		}
    		if(nums[mid] >= nums[l]) {
    			if(target < nums[mid] && target >= nums[l]) {
    				h = mid - 1;
    			} else {
    				l = mid + 1;
    			}
    		} else {
    			if(target > nums[mid] && target < nums[l]) {
    				l = mid + 1;
    			} else {
    				h = mid - 1;
    			}
    		}
    	}
    	return target == nums[l] ? l : -1;
    }

    private int searchMyVersion(int[] nums, int target) {
    	int n = nums.length;
    	if(n == 0) {
    		return -1;
    	}
    	if(nums[0] <= nums[n-1]) {
    		return binaraySearch(nums, 0, n, target);
    	}
    	int maxi =findMax(nums);
    	if(target == nums[0]) {
    		return 0;
    	} else if(target > nums[0]) {
    		return binaraySearch(nums, 0, maxi+1,target);
    	} else {
    		return binaraySearch(nums, maxi+1, n, target);
    	}


    }

    private int findMax(int[] nums) {
    	int l = 0, h = nums.length - 1;
    	while(l <= h) {
    		if(l == h) {
    			return l;
    		} else if(l+1 == h) {
    			return nums[l] < nums[h] ? h : l;
    		}
    		int mid = (l+h)/2;
    		if(nums[mid] < nums[l]) {
    			h = mid - 1;
    		} else if(nums[mid] > nums[l]) {
    			l = mid;
    		}
    	}
    	return -1;
    }

    private int binaraySearch(int[] nums, int s, int e, int target) {
    	if(s >= e) {
    		return -1;
    	}
    	int l = s, h = e-1;
    	while(l <= h) {
    		int mid = (l+h)/2;
    		if(nums[mid] == target) {
    			return mid;
    		} else if(nums[mid] < target) {
    			l = mid + 1;
    		} else {
    			h = mid - 1;
    		}
    	}
    	return -1;
    }
}
