class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n==0) {
        	return;
        }
        for(int i=0; i<=(n-1)/2; i++) {
        	for(int j=i; j<=n-i-2; j++) {
        		swap(matrix,n,i,j);
        	}
        }
    }

    private void swap(int[][] m, int n, int i, int j) {
    	int t=m[i][j];
    	m[i][j] = m[n-1-j][i];
    	m[n-1-j][i] = m[n-1-i][n-1-j];
    	m[n-1-i][n-1-j] = m[j][n-1-i];
    	m[j][n-1-i] = t;
    }
}
