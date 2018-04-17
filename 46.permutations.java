class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return new ArrayList<>();
        }
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return permute(l);
    }

    private List<List<Integer>> permute(List<Integer> nums) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(nums.size() == 1) {
    		List<Integer> result = new ArrayList<>();
    		result.add(nums.get(0));
    		results.add(result);
    		return results;
    	}
    	for(int i=0; i<nums.size(); i++) {
    		if(i > 0 && nums.get(i) == nums.get(i-1)) {
    			continue;
    		}
    		int tmp = nums.remove(i);
    		List<List<Integer>> ri = permute(nums);
    		for(List<Integer> r : ri) {
    			r.add(0, tmp);
    			results.add(r);
    		}
    		nums.add(i, tmp);
    	}
    	return results;
    }

}
