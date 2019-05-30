class Solution {
    public int numSquares(int n) {
    	Map<Integer, Integer> map = new HashMap<>();
    	for(int i=1; i*i <= n; i++) {
    		map.put(i*i, 1);
    	}
    	return numSquares(n, map);
    }

    private int numSquares(int n, Map<Integer, Integer> map) {
    	if(map.containsKey(n)) {
    		return map.get(n);
    	}
    	int result = n;
    	for(int i=1; i*i < n; i++) {
    		result = Math.min(result, 1+numSquares(n-i*i, map));
    	}
    	map.put(n, result);
    	return result;
    }
}
