class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return new ArrayList<>();
        }
        return permute(nums, 0);
    }
    private List<List<Integer>> permute(int[] nums, int st) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(st == nums.length-1) {
    		List<Integer> result = new ArrayList<>();
    		result.add(nums[st]);
    		results.add(result);
    		return results;
    	}
    	Set<Integer> sets = new HashSet<>();
    	for(int i=st; i<nums.length; i++) {
    		if(sets.contains(nums[i])) {
    			continue;
    		}
    		sets.add(nums[i]);
    		insertHead(nums, st, i);
    		List<List<Integer>> ri = permute(nums, st+1);
    		for(List<Integer> r : ri) {
    			r.add(0, nums[st]);
    			results.add(r);
    		}
    		recover(nums, st, i);
    	}
    	return results;
    }

    void insertHead(int[] nums, int i, int j) {
    	if(i == j) {
    		return;
    	}
    	int tmp = nums[j];
    	for(int k=j; k>i;k--) {
    		nums[k] = nums[k-1];
    	}
    	nums[i] = tmp;
    }

    void recover(int[] nums, int i, int j) {
    	if(i == j) {
    		return;
    	}
    	int tmp = nums[i];
    	for(int k=i; k<j; k++) {
    		nums[k] = nums[k+1];
    	}
    	nums[j] = tmp;
    }
}
