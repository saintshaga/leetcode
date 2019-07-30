class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2) {
        	return 0;
        }
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int max = height[0];
        for(int i=0; i<n; i++) {
        	max = Math.max(height[i], max);
        	left[i] = max;
        }
        max=height[n-1];
        for(int i=n-1; i>=0; i--) {
        	max = Math.max(height[i], max);
        	right[i] = max;
        }
        int result = 0;
        for(int i=0; i<n; i++) {
        	result += Math.min(left[i], right[i]) - height[i];
        }
        return result;
    }
}
