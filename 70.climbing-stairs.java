class Solution {
    public int climbStairs(int n) {
        if(n == 0) {
        	return 0;
        }
        int[] c = new int[n+1];
        c[0] = 1;
        c[1] = 1;
        for(int i=2; i<=n; i++) {
        	c[i] = c[i-1] + c[i-2];
        }
        return c[n];
    }
}
