class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> results = new ArrayList<>();
    	int n = candidates.length;
    	if(n == 0) {
    		return results;
    	}
    	Arrays.sort(candidates);
    	return combinationSum(candidates, 0, target);
    	// return combinationSortedSum(candidates, target);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int st, int target) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(st >= candidates.length || target < candidates[st]) {
    		return new ArrayList<>();
    	}
    	int repeatNum = target/candidates[st];
    	if(st == candidates.length-1) {
    		if(target % candidates[st] != 0) {
    			return new ArrayList<>();
    		} else {
    			results.add(new ArrayList<>());
    			insertRepeatNum(results, candidates[st], repeatNum);
    			return results;
    		}
    	}
    	for(int i=0; i<=repeatNum; i++) {
    		if(target == i * candidates[st]) {
    			results.add(initializeListWithRepeatedNumbers(candidates[st], i));
    			break;
    		} else {
	    		List<List<Integer>> ri = combinationSum(candidates, st+1, target-i * candidates[st]);
	    		if(ri != null && !ri.isEmpty()) {
	    			insertRepeatNum(ri, candidates[st], i);
	    			results.addAll(0, ri);
	    		}
    		}
    	}
    	return results;
    }

    private void insertRepeatNum(List<List<Integer>> results, int element, int repeatNum) {
    	if(repeatNum <= 0) {
    		return;
    	}
    	List<Integer> added = initializeListWithRepeatedNumbers(element, repeatNum);
    	for(List<Integer> result : results) {
    		result.addAll(0, added);
    	}
    }

    private List<Integer> initializeListWithRepeatedNumbers(int element, int repeatNum) {
    	List<Integer> added = new ArrayList<>(repeatNum);
    	for(int i=0; i<repeatNum; i++) {
    		added.add(element);
    	}
    	return added;
    }


    private List<List<Integer>> combinationSortedSum(int[] candidates, int target) {
    	if(target < candidates[0]) {
    		return null;
    	}
    	List<List<Integer>> results = new ArrayList<>();
    	for(int i=0; i<candidates.length; i++) {
    		if(target < candidates[i]) {
    			break;
    		} else if(target == candidates[i]) {
    			List<Integer> result = new ArrayList<>();
    			result.add(candidates[i]);
    			results.add(result);
    		} else {
	    		List<List<Integer>> ri = combinationSortedSum(candidates, target - candidates[i]);
	    		if(ri != null) {
	    			for(List<Integer> r : ri) {
	    				r.add(candidates[i]);
	    				results.add(r);
	    			}
	    		}
    		}
    	}
    	return results;
    }
}
