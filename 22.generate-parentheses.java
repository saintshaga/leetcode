class Solution {
    public List<String> generateParenthesis(int n) {
        if(n <= 0) {
        	return new ArrayList<>();
        }
        List<List<String>> results = new ArrayList<>();
        List<String> r0 = new ArrayList<>();
        r0.add("");
        results.add(r0);
        for(int i=1; i<=n; i++) {
        	List<String> ri = new ArrayList<>();
        	for(int j=i-1; j>=0; j--) {
        		ri.addAll(combine(results.get(j), results.get(i-1-j)));
        	}
        	results.add(ri);
        }
        return results.get(n);
    }

    private List<String> combine(List<String> p1, List<String> p2) {
    	List<String> results = new ArrayList<>();
    	for(int i=0; i<p1.size(); i++) {
    		for(int j=0; j<p2.size(); j++) {
    			results.add("(" + p1.get(i) + ")"+ p2.get(j));
    		}
    	}
    	return results;
    }
}
