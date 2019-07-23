class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
        	return;
        }
        int m=board.length, n = board[0].length;
        int[][] record = new int[m][n];
        Stack<Position> stack = new Stack<>();
        Set<Integer> surrounedSet = new HashSet<>();
        int sign = 1;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(board[i][j] == 'X') {
        			record[i][j] = -1;
        			continue;
        		}
        		if(board[i][j] == 'O' && record[i][j] != 0) {
        			continue;
        		}
        		stack.push(new Position(i, j));
        		surrounedSet.add(sign);
        		while(!stack.isEmpty()) {
        			Position current = stack.pop();
        			int r = current.r, c=current.c;
        			record[r][c] = sign;
        			if(surrounedSet.contains(sign) && isBorder(current, m, n)) {
        				surrounedSet.remove(sign);
        			}
        			if(r > 0 && board[r-1][c]=='O' && record[r-1][c] == 0) {
        				stack.push(new Position(r-1, c));
        			}
        			if(r < m-1 && board[r+1][c] == 'O' && record[r+1][c] == 0) {
        				stack.push(new Position(r+1, c));
        			}
        			if(c > 0 && board[r][c-1] == 'O' && record[r][c-1] == 0) {
        				stack.push(new Position(r, c-1));
        			}
        			if(c < n-1 && board[r][c+1] == 'O' && record[r][c+1] == 0) {
        				stack.push(new Position(r, c+1));
        			}
        		}
        		sign++;
        	}
        }
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(board[i][j] == 'O' && surrounedSet.contains(record[i][j])) {
        			board[i][j] = 'X';
        		}
        	}
        }
    }

    private static class Position {
    	int r;
    	int c;
    	Position(int x, int y) {
    		r = x;
    		c = y;
    	}
    }

    private boolean isBorder(Position position, int m, int n) {
    	return position.r == 0 || position.r == m-1 || position.c == 0 || position.c == n-1;
    }


}
