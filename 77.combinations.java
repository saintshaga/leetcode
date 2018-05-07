class Solution {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> results = new ArrayList<>();
        if(k <= 0) {
        	return results;
        } else if(k > n) {
        	results.add(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));
        	return results;
        }
    	for(int i=1; i<=n-k+1; i++) {
    		results.addAll(combine(i, n, k));
    	}
    	return results;
    }

    private List<List<Integer>> combine(int st, int n, int k) {
    	List<List<Integer>> results = new ArrayList<>();
    	if(k == 1) {
    		List<Integer> result = new ArrayList<>();
    		result.add(st);
    		results.add(result);
    		return results;
    	}
    	for(int i=st+1; i<=n-k+2; i++) {
    		List<List<Integer>> ri = combine(i, n, k-1);
    		for(List<Integer> r : ri) {
    			r.add(0, st);
    			results.add(r);
    		}
    	}
    	return results;
    }
}
