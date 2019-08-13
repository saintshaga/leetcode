class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 2 || prerequisites.length < 2) {
        	return true;
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
        	list.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++) {
        	list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] colors = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
        	colors[i] = WHITE;
        }
        for(int i=0; i<numCourses; i++) {
        	if(colors[i] == WHITE && !dfs(i, list, colors)) {
        		return false;
        	}
        }
        return true;
    }
    //return false if there is circle, otherwise return true
    private boolean dfs(int start, List<List<Integer>> list, int[] colors) {
    	colors[start] = GRAY;
    	boolean result = true;
    	List<Integer> edges = list.get(start);
    	for(int edge : edges) {
    		if(colors[edge] == WHITE) {
    			result = result & dfs(edge, list, colors);
    		} else if(colors[edge] == GRAY) {
    			result = false;
    		}
    	}
    	colors[start] = BLACK;
    	return result;
    }

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
}
