class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        results.add(0);
        for(int i=1; i<=n; i++) {
        	int base = (int)Math.pow(2, i-1);
        	for(int j=results.size()-1; j>=0; j--) {
        		results.add(base + results.get(j));
        	}
        }
        return results;
    }
}
