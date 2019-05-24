class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1 || k%(nums.length) == 0) {
        	return;
        }
        k = k % (nums.length);
        List<Integer> original = IntStream.of(nums).boxed().collect(Collectors.toList());
        for(int i=0; i<nums.length; i++) {
        	int index = (nums.length - k + i) % nums.length;
        	nums[i] = original.get(index);
        }
    }
}
