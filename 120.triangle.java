class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> c = new ArrayList<>();
        if(triangle.size() == 0) {
        	return 0;
        }
        c.add(triangle.get(0).get(0));
        for(int i=1; i<triangle.size(); i++) {
        	List<Integer> thisRow = triangle.get(i);
        	int lastNumber = c.get(c.size()-1) + thisRow.get(thisRow.size()-1);
        	for(int j=c.size()-1; j>=0; j--) {
        		c.set(j, (j == 0 ? c.get(j) : Math.min(c.get(j), c.get(j-1))) + thisRow.get(j));
        	}
        	c.add(lastNumber);
        }
        int min = c.get(0);
        for(int i : c) {
        	min = Math.min(min, i);
        }
        return min;
    }
}
