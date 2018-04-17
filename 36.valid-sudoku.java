class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
        	return false;
        }
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] blocks = new Set[9];
        for(int i=0; i<9; i++) {
        	rows[i] = new HashSet<>();
        	columns[i] = new HashSet<>();
        	blocks[i] = new HashSet<>();
        }
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] == '.') {
        			continue;
        		} else {
        			int blocki = (i/3)*3 + j/3;
        			if(rows[i].contains(board[i][j]) 
        				|| columns[j].contains(board[i][j]) 
        				|| blocks[blocki].contains(board[i][j])) {
        				return false;
        			} else {
        				rows[i].add(board[i][j]);
        				columns[j].add(board[i][j]);
        				blocks[blocki].add(board[i][j]);
        			}
        		}
        	}
        }
        return true;
    }
}
