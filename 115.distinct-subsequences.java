class Solution {
    public int numDistinct(String s, String t) {
    	int m = s.length();
    	int n = t.length();
    	int[][] b = new int[m+1][n+1];
    	for(int i=0; i<=m; i++) {
    		b[i][n] = 1;
    	}
    	for(int i=0; i<n; i++) {
    		b[m][i] = 0;
    	}
    	for(int i=n-1; i>=0; i--) {
    		for(int j=m-1; j>=0; j--) {
    			b[j][i] = b[j+1][i];
    			if(t.charAt(i) == s.charAt(j)) {
    				b[j][i] += b[j+1][i+1];
    			}
    		}
    	}
    	return b[0][0];
    }
}
