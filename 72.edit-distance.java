class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
        	return -1;
        }
        int n1 = word1.length(), n2 = word2.length();
        int[][] c = new int[n1+1][n2+1];
        c[0][0] = 0;
        for(int i=1; i<=n1; i++) {
        	c[i][0] = i;
        }
        for(int i=1; i<=n2; i++) {
        	c[0][i] = i;
        }
        for(int i=1; i<=n1; i++) {
        	for(int j=1; j<=n2; j++) {
        		char c1 = word1.charAt(i-1);
        		char c2 = word2.charAt(j-1);
        		if(c1 == c2) {
        			c[i][j] = c[i-1][j-1];
        		} else {
        			c[i][j] = Math.min(Math.min(c[i-1][j-1], c[i-1][j]), c[i][j-1]) + 1;
        		}
        	}
        }
        return c[n1][n2];
    }
}
