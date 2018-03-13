class Solution {
    public int jump(int[] nums) {
        int n= nums.length;
        if(n <= 1) {
        	return 0;
        }
        int step = 0, currentMax = -1, nextMax = 0;
        for(int i=0; i<n; i++) {
        	if(i > currentMax) {
        		step++;
        		currentMax = nextMax;
        	}
        	if(nums[i] + i >= n-1) {
        		return step;
        	}
        	nextMax = Math.max(nextMax,nums[i] + i);
        }
        return step;
    }

    private int jumpOn2(int[] nums) {
        int n= nums.length;
        if(n <= 1) {
        	return 0;
        }
        int[] c = new int[n];
        c[n-1] = 0;
        for(int i=n-2; i>=0; i--) {
        	c[i] = n-1;
        	int steps = Math.min(nums[i], n-1-i);
        	for(int j=1; j<=steps; j++) {
        		if(c[i+j] < c[i]) {
        			c[i] = c[i+j];
        		}
        	}
        	c[i] += 1;
        }
        return c[0] == n ? 0 : c[0];
    }
}
