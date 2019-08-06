class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
        	return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++) {
        	while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
        		int current = stack.pop();
        		int startExclusive = stack.isEmpty() ? -1 : stack.peek();
        		max = Math.max(max, heights[current]*(i-startExclusive-1));
        	}
        	stack.push(i);
        }
        while(!stack.isEmpty()) {
        	int current = stack.pop();
        	int startExclusive = stack.isEmpty() ? -1 : stack.peek();
        	max = Math.max(max, heights[current]*(heights.length-startExclusive-1));
        }
        return max;
    }
}
