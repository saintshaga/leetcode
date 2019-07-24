class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
        	return new int[0];
        }
        int n = nums.length;
        int[] results = new int[n-k+1];
        int resultIndex = 0;
        Deque<Integer> dequeue = new LinkedList<>();
        for(int i=0; i<n; i++) {
        	while(!dequeue.isEmpty() && dequeue.getFirst() <= i-k) {
        		dequeue.removeFirst();
        	}
        	while(!dequeue.isEmpty() && nums[dequeue.getLast()] <= nums[i]) {
        		dequeue.removeLast();
        	}
        	dequeue.addLast(i);
        	if(i-k+1 >= 0) {
        		results[resultIndex++] = nums[dequeue.getFirst()];
        	}
        }
        return results;
    }
}
