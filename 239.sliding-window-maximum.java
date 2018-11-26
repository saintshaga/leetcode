class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        if(nums.length <= 1) {
        	return nums;
        }
        int[] results = new int[nums.length-k+1];
        for(int i=0; i<nums.length; i++) {
        	while(!deque.isEmpty() && deque.getFirst() < i-k+1) {
        		deque.removeFirst();
        	}
        	while(!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
        		deque.removeLast();
        	}
        	deque.addLast(i);
        	if(i-k+1 >= 0) {
        		results[i-k+1] = nums[deque.getFirst()];
        	}
        }
        return results;
    }
}
