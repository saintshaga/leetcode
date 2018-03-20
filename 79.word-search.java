class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) {
        	return true;
        }
        if(board.length == 1 && board[0].length == 1) {
        	return word.length() == 1 && board[0][0] == word.charAt(0);
        }
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(search(board, i, j, word, 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int k) {
    	if(k >= word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
    		return false;
    	}
    	if(board[i][j] != word.charAt(k)) {
    		return false;
    	}
    	char temp = board[i][j];
    	board[i][j] = 0;
    	if(search(board, i-1, j, word, k+1)) {
    		return true;
    	}
    	if(search(board, i+1, j, word, k+1)) {
    		return true;
    	}
    	if(search(board, i, j-1, word, k+1)) {
    		return true;
    	}
    	if(search(board, i, j+1, word, k+1)) {
    		return true;
    	}
    	board[i][j] = temp;
    	return false;
    }
}
