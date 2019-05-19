class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length <= 1) {
        	return nums;
        }
        int n = nums.length;
        int[] left2Right = new int[n];
        int[] right2Left = new int[n];
        left2Right[0] = 1;
        right2Left[n-1] = 1;
        for(int i=1; i<n; i++) {
        	left2Right[i] = left2Right[i-1] * nums[i-1];
        }
        for(int i=n-2; i>=0; i--) {
        	right2Left[i] = right2Left[i+1] * nums[i+1];
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
        	result[i] = left2Right[i] * right2Left[i];
        }
        return result;
    }
}
