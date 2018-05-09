class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
        	return false;
        }
        int m = s1.length(), n=s2.length();
        boolean[][] c = new boolean[m+1][n+1];
        c[0][0] = true;
        for(int i=1; i<=m; i++) {
        	c[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && c[i-1][0];
        }
        for(int i=1; i<=n; i++) {
        	c[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && c[0][i-1];
        }
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		if(s1.charAt(i-1) == s3.charAt(i+j-1) && s2.charAt(j-1) == s3.charAt(i+j-1)) {
        			c[i][j] = c[i-1][j] || c[i][j-1];
        		} else if(s1.charAt(i-1) == s3.charAt(i+j-1)) {
        			c[i][j] = c[i-1][j];
        		} else if(s2.charAt(j-1) == s3.charAt(i+j-1)) {
        			c[i][j] = c[i][j-1];
        		} else {
        			c[i][j] = false;
        		}
        	}
        }
        return c[m][n];
    }

}
