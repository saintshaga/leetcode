class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
        	return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] gridInt = new int[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		gridInt[i][j] = grid[i][j] == '1' ? 1 : 0;
        	}
        }
        int flag = 2;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(gridInt[i][j] != 1) {
        			continue;
        		}
        		Queue<Position> queue = new LinkedList<>();
        		queue.offer(new Position(i, j));
        		while(!queue.isEmpty()) {
        			Position current = queue.poll();
        			if(gridInt[current.r][current.c] != 1) {
        				continue;
        			}
        			gridInt[current.r][current.c] = flag;
        			if(current.r > 0 && gridInt[current.r-1][current.c] == 1) {
        				queue.offer(new Position(current.r-1, current.c));
        			}
        			if(current.r < m-1 && gridInt[current.r+1][current.c] == 1) {
        				queue.offer(new Position(current.r+1, current.c));
        			}
        			if(current.c > 0 && gridInt[current.r][current.c-1] == 1) {
        				queue.offer(new Position(current.r, current.c-1));
        			}
        			if(current.c < n-1 && gridInt[current.r][current.c+1] == 1) {
        				queue.offer(new Position(current.r, current.c+1));
        			}
        		}
        		flag++;
        	}
        }
        return flag-2;
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
