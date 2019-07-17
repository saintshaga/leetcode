class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] c = new int[m][n];
        int max = 0;
        for(int i=0; i<m; i++) {
        	c[i][0] = matrix[i][0] == '1' ? 1 : 0;
        	max = Math.max(max, c[i][0]);
        }
        for(int i=1; i<n; i++) {
        	c[0][i] = matrix[0][i] == '1' ? 1 : 0;
        	max = Math.max(max, c[0][i]);
        }
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if(matrix[i][j] == '1') { 
        			int row = rowAreOne(matrix, i, j-c[i-1][j-1], j);
        			int col = columnAreOne(matrix, j, i-c[i-1][j-1], i);
        			c[i][j] = Math.min(row, col) + 1;
        			max = Math.max(max, c[i][j]);
        		} else {
        			c[i][j] = 0;
        		}
        	}
        }
        return max*max;
    }

    private int rowAreOne(char[][] matrix, int row, int stc, int edc) {
    	int count = 0;
    	for(int i=edc-1; i>=stc; i--) {
    		if(matrix[row][i] == '0') {
    			return count;
    		}
    		count++;
    	}
    	return count;
    }

    private int columnAreOne(char[][] matrix, int col, int str, int edr) {
    	int count = 0;
    	for(int i=edr-1; i>=str; i--) {
    		if(matrix[i][col] == '0') {
    			return count;
    		}
    		count++;
    	}
    	return count;
    }
}
