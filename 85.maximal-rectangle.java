class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int m = matrix.length, n=matrix[0].length;
        int[][] c = new int[m][n];
        for(int i=0; i<n; i++) {
        	c[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        int result = maximalRectangle(c[0]);
        for(int i=1; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		c[i][j] = matrix[i][j] == '1' ? c[i-1][j] + 1 : 0;
        	}
        	result = Math.max(result, maximalRectangle(c[i]));
        }
        return result;
    }

    private int maximalRectangle(int[] nums) {
    	if(nums.length == 0 ) {
    		return 0;
    	}
    	Stack<Integer> stack = new Stack<>();
    	int max = 0;
    	for(int i=0; i<nums.length; i++) {
  			while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
   				int j = stack.pop();
	    		int li = stack.isEmpty() ? -1 : stack.peek();
   				max = Math.max(nums[j]*(i-li-1), max);
   			}
   			stack.push(i);
    	}
    	while(!stack.isEmpty()) {
    		int j = stack.pop();
    		int li = stack.isEmpty() ? -1 : stack.peek();
			max = Math.max(nums[j]*(nums.length-li-1), max);
    	}
    	return max;
    }

    private int maximalRectangle2(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int m = matrix.length, n=matrix[0].length;
        int[][] w = new int[m][n];
        int[][] h = new int[m][n];
        for(int i=0; i<m; i++) {
        	for (int j=0;j<n; j++) {
        		w[i][j] = matrix[i][j] == '0' ? 0 : (j >= 1 ? w[i][j-1] : 0)+1;
        		h[i][j] = matrix[i][j] == '0' ? 0 : (i >= 1 ? h[i-1][j] : 0)+1;
        	}
        }
        int[][] max = new int[m][n];
        int result = 0;
        for(int i=0; i < n; i++) {
        	max[0][i] = w[0][i];
        	result = Math.max(result, max[0][i]);
        }
        for(int i=0; i<m; i++) {
        	max[i][0] = h[i][0];
        	result = Math.max(result, max[i][0]);
        }
        for(int i=1; i<m; i++) {
        	for(int j=1; j<n; j++) {
        		if(matrix[i][j] == '0') {
        			max[i][j] = 0;
        			w[i][j] = 0;
        			h[i][j] = 0;
        		} else {
        			int upDownW = Math.min(max[i-1][j]/Math.max(h[i-1][j],1), w[i][j]);
        			int upDownH =  h[i-1][j] + 1;
        			int upDown = upDownW*upDownH;
        			int leftRightW = w[i][j-1] + 1;
        			int leftRightH = Math.min(max[i][j-1]/Math.max(w[i][j-1],1), h[i][j]);
        			int leftRight = leftRightW * leftRightH;
        			if(upDown > leftRight) {
        				max[i][j] = upDown;
        				h[i][j] = h[i-1][j] + 1;
        				w[i][j] = upDown/h[i][j];
        			} else if(upDown < leftRight) {
        				max[i][j] = leftRight;
        				w[i][j] = w[i][j-1] + 1;
        				h[i][j] = leftRight/w[i][j];
        			} else {
        				max[i][j] = upDown;
        				w[i][j] = Math.max(upDownW, leftRightW);
        				h[i][j] = Math.max(upDownH, leftRightH);
        			}
        		}
	        	result = Math.max(result, max[i][j]);
        	}
        }
        return result;
    }
}
