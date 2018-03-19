class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for(int i=0; i<nums.length; i++) {
        	int n = results.size();
        	for(int j=0; j<n; j++) {
        		List<Integer> ri = new ArrayList<>(results.get(j));
        		ri.add(nums[i]);
        		results.add(ri);
        	}
        }
        return results;
    }

    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<List<Integer>> lastResult = new ArrayList<>();
        lastResult.add(new ArrayList<>());
        results.addAll(lastResult);
        List<Integer> lastMaxIndices = new ArrayList<>();
        lastMaxIndices.add(-1);
        for(int i=1; i<=nums.length; i++) {
        	List<List<Integer>> ri = new ArrayList<>();
        	List<Integer> maxIndices = new ArrayList<>();
        	for(int j=0; j<lastResult.size(); j++) {
        		int maxIndex = lastMaxIndices.get(j);
        		for(int k=maxIndex+1; k<nums.length; k++) {
        			List<Integer> rik = new ArrayList<>(lastResult.get(j));
        			rik.add(nums[k]);
        			ri.add(rik);
        			maxIndices.add(k);
        		}
        	}
        	results.addAll(ri);
        	lastResult = ri;
        	lastMaxIndices = maxIndices;
        }
        return results;
    }
}
