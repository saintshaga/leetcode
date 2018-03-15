class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid.length == 0 || obstacleGrid[0].length==0) {
    		return 0;
    	}
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] c = new int[m][n];
        c[0][0] = obstacleGrid[0][0] == 0? 1 : 0;
        for(int i=1; i < n; i++) {
        	c[0][i] = obstacleGrid[0][i] == 0 ? 1 : 0;
        	c[0][i] = Math.min(c[0][i], c[0][i-1]);
        }
        for(int i=1; i<m; i++) {
        	c[i][0] = obstacleGrid[i][0] == 0 ? 1 : 0;
        	c[i][0] = Math.min(c[i][0], c[i-1][0]);
        }
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			c[i][j] = 0;
        		} else {
	        		c[i][j] = c[i-1][j] + c[i][j-1];
        		}
        	}
        }
        return c[m-1][n-1];
    }
}
