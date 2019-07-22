class KthLargest {
	private int k;
	private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for(int i:nums) {
        	add(i);
        }
    }
    
    public int add(int val) {
        if(queue.size() < k) {
        	queue.offer(val);
        } else if(val > queue.peek()) {
        	queue.poll();
        	queue.offer(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
