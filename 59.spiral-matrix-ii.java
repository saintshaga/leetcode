class Solution {
    public int[][] generateMatrix(int n) {
        int[][] results  = new int[n][n];
        if(n == 0) {
        	return results;
        }
        int number = 1;
        for(int i = 0; i<=(n-1)/2; i++) {
        	number = fill(results, i, number, n);
        }
        return results;
    }

    private int fill(int[][] r, int i, int st, int size) {
    	int n = size - 2*i;
    	if(n == 1) {
    		r[i][i] = st++;
    		return st;
    	}
    	int a1=st,a2=st+n-1,a3=st+2*(n-1),a4=st+3*(n-1);
    	for(int j=0; j<n-1;j++) {
    		r[i][i+j] = a1++;
    		r[i+j][i+n-1] = a2++;
    		r[i+(n-1)][i+(n-1-j)] = a3++;
    		r[i+(n-1-j)][i] = a4++;
    	}
    	return st+4*(n-1);
    }
}
