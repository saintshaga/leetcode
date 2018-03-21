class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
        	return s;
        }
        int n = s.length();
        char[] a = s.toCharArray();
        boolean[][] c = new boolean[n][n];
        int st = 0, maxLength = 0;
        for(int delta=0; delta<=n-1; delta++) {
        	for(int i=0; i <= n-1-delta; i++) {
        		if(delta == 0) {
        			c[i][i+delta] = true;
        		} else if(delta == 1) {
        			c[i][i+delta] = a[i] == a[i+delta] ? true : false;
        		} else {
        			c[i][i+delta] = a[i] == a[i+delta] ? c[i+1][i+delta-1] : false;
        		}
        		if(c[i][i+delta] && (delta+1) > maxLength) {
        			st = i;
        			maxLength = delta + 1;
        		}
        	}
        }
        return s.substring(st, st+maxLength);

    }

    private String longestPalindrome2(String s) {
        if(s == null || s.length() <= 1) {
        	return s;
        }
        int n = s.length();
        char[] a = s.toCharArray();
        char[] b = new char[n];
        for(int i=0; i<n; i++) {
        	b[i] = a[n-1-i];
        }
        int[][] c = new int[n+1][n+1];
        int maxLength = 0, index = 0;
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		c[i][j] = a[i-1] == b[j-1] ? c[i-1][j-1] + 1 : 0;
        		if(c[i][j] > maxLength && (i+j) == (n+c[i][j])) {
        			maxLength = c[i][j];
        			index = i-1;
        		}
        	}
        }
        if(maxLength == 0) {
        	return "";
        }
        return s.substring(index+1-maxLength, index+1);
    }

}
