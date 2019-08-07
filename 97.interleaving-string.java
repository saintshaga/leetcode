class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length()+s2.length() != s3.length()) {
        	return false;
        }
        int n1 = s1.length(), n2 = s2.length();
        boolean[][] c = new boolean[n1+1][n2+1];
        c[0][0] = true;
        for(int i=1; i<=n1; i++) {
        	c[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && c[i-1][0];
        }
        for(int i=1; i<=n2; i++) {
        	c[0][i] = s2.charAt(i-1) == s3.charAt(i-1) && c[0][i-1];
        }
        for(int i=1; i<=n1; i++) {
        	for(int j=1; j<=n2; j++) {
        		char c1 = s1.charAt(i-1);
        		char c2 = s2.charAt(j-1);
        		char c3 = s3.charAt(i+j-1);
        		if(c1 == c3 && c2 == c3) {
        			c[i][j] = c[i-1][j] || c[i][j-1];
        		} else if(c1 == c3) {
        			c[i][j] = c[i-1][j];
        		} else if(c2 == c3) {
        			c[i][j] = c[i][j-1];
        		} else {
        			c[i][j] = false;
        		}
        	}
        }
        return c[n1][n2];
    }
}
