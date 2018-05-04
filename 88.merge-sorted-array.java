class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m-1; i>=0; i--) {
        	nums1[i+n] = nums1[i];
        }
        int i=n,j=0,k=0;
        while(i < m+n && j < n) {
        	if(nums1[i] < nums2[j]) {
        		nums1[k++] = nums1[i++];
        	} else {
        		nums1[k++] = nums2[j++];
        	}
        }
        if(i < m+n) {
        	assignRest(nums1, k, nums1, i, m+n);
        } else if(j < n) {
        	assignRest(nums1, k, nums2, j, n);
        }
    }

    private void assignRest(int[] nums1, int k, int[] nums, int st, int ed) {
    	for(int i=st; i<ed; i++) {
    		nums1[k++] = nums[i];
    	}
    }
}
