class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) {
        	return 0;
        }
        int result  = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++) {
        	if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
        		stack.push(i);
        	} else {
        		while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
        			int j = stack.pop();
        			int st = stack.isEmpty() ? -1 : stack.peek();
        			if(result < (i-st-1) * heights[j]) {
        				result = (i-st-1) * heights[j];
        			}
        		}
        		stack.push(i);
        	}
        }
        while(!stack.isEmpty()) {
        	int j = stack.pop();
        	int st = stack.isEmpty() ? -1 : stack.peek();
        	if(result < (heights.length-st-1) * heights[j]) {
        		result = (heights.length-st-1) * heights[j];
        	}
        }
        return result;
    }
}
