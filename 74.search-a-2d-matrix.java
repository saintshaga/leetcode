class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) {
        	return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int lr = 0, hr = m-1, mr = 0;
        while(lr <= hr) {
        	mr = (lr + hr)/2;
        	if(matrix[mr][0] == target) {
        		return true;
        	} else if(target > matrix[mr][0]) {
        		lr = mr + 1;
        	} else {
        		hr = mr - 1;
        	}
        }
        int row = target < matrix[mr][0] ? mr : mr+1;
        if(row == 0) {
        	return false;
        }
        row--;
        int lc = 0, hc = n-1, mc = 0;
        while(lc <= hc) {
        	mc = (lc + hc)/2;
        	if(matrix[row][mc] == target) {
        		return true;
        	} else if(target > matrix[row][mc]) {
        		lc = mc + 1;
        	} else {
        		hc = mc - 1;
        	}
        }
        return false;
    }
}
