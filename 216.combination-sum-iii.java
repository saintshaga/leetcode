class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || k > 9) {
        	return Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<>();
        combination(results, new ArrayList<>(), k, n, 1);
        return results;
    }

    private void combination(List<List<Integer>> results, List<Integer> current, int k, int n, int startNum) {
    	if(k == 0 && n == 0 && !current.isEmpty()) {
    		results.add(current.stream().collect(Collectors.toList()));
    	}
    	if(k <= 0 || n < 0) {
    		return;
    	}
    	for(int i=startNum; i<=10-k; i++) {
    		current.add(i);
    		combination(results, current, k-1, n-i, i+1);
    		current.remove(current.size() - 1);
    	}
    }
}
