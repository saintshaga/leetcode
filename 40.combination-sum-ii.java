class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0) {
        	return new ArrayList<>();
        }
        Arrays.sort(candidates);
        return combinationSum2(candidates, 0, target);
    }

    private List<List<Integer>> combinationSum2(int[] candidates, int st, int target) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(target < candidates[st]) {
    		return results;
    	}
    	int ed = st + 1;
    	while(ed < candidates.length && candidates[ed] == candidates[st]) {
    		ed++;
    	}
    	int repeatNum = Math.min(ed-st, target/candidates[st]);
    	for(int i=0; i<=repeatNum; i++) {
    		if(target == i*candidates[st]) {
    			results.add(0, constructListWithRepeatedNumber(candidates[st], i));
    			return results;
    		} else if(ed < candidates.length) {
    			List<List<Integer>> ri = combinationSum2(candidates, ed, target-i*candidates[st]);
    			if(ri != null && !ri.isEmpty()) {
    				for(List<Integer> r : ri) {
    					r.addAll(0, constructListWithRepeatedNumber(candidates[st], i));
    				}
    				results.addAll(0, ri);
    			}
    		}
    	}
    	return results;
    }

    private List<Integer> constructListWithRepeatedNumber(int number, int repeatNum) {
    	List<Integer> result = new ArrayList<>();
    	for(int i=0; i<repeatNum; i++) {
    		result.add(number);
    	}
    	return result;
    }
}
