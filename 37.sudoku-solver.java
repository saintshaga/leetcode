class Solution {
    public void solveSudoku(char[][] board) {
        Set<Character>[] rows = new Set[9];
        Set<Character>[] columns = new Set[9];
        Set<Character>[] blocks = new Set[9];
        List<Position> blanks = new LinkedList<>();
        for(int i=0; i<9; i++) {
        	rows[i] = new HashSet<>();
        	columns[i] = new HashSet<>();
        	blocks[i] = new HashSet<>();
        }
        for(int i=0; i<9; i++) {
        	for(int j=0; j<9; j++) {
        		if(board[i][j] == '.') {
        			blanks.add(new Position(i,j));
        		} else {
        			int blocki = (i/3)*3 + j/3;
       				rows[i].add(board[i][j]);
       				columns[j].add(board[i][j]);
       				blocks[blocki].add(board[i][j]);
        		}
        	}
        }
        solveSudoku(board, rows, columns, blocks, blanks);
    }

    private boolean solveSudoku(char[][] board, 
    	Set<Character>[] rows, Set<Character>[] columns, Set<Character>[] blocks, 
    	List<Position> blanks) {
    	if(blanks.isEmpty()) {
    		return true;
    	}
    	Position p = blanks.get(0);
    	for(char c = '1'; c <= '9'; c++) {
    		int i = (p.r/3)*3 + p.c/3;
    		if(!rows[p.r].contains(c) && !columns[p.c].contains(c) && !blocks[i].contains(c)) {
    			board[p.r][p.c] = c;
    			rows[p.r].add(c);
    			columns[p.c].add(c);
    			blocks[i].add(c);
    			blanks.remove(0);
    			if(solveSudoku(board, rows, columns, blocks, blanks)) {
    				return true;
    			} else {
	    			board[p.r][p.c] = '.';
    				rows[p.r].remove(c);
    				columns[p.c].remove(c);
    				blocks[i].remove(c);
    				blanks.add(0, p);
    			}
    		}
    	}
    	return false;
    }

    private static class Position {
    	int r;
    	int c;
    	Position(int i, int j) {
    		r = i;
    		c = j;
    	}
    }
}
