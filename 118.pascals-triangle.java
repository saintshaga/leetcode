class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
        	List<Integer> result = new ArrayList<>();
        	result.add(1);
        	if(i > 1) {
        		List<Integer> lastLine = results.get(i-1-1);
        		for(int j=0; j<lastLine.size()-1; j++) {
        			result.add(lastLine.get(j) + lastLine.get(j+1));
        		}
        		result.add(1);
        	}
        	results.add(result);
        }
        return results;
    }
}
