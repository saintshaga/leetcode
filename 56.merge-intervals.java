/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	if(intervals == null || intervals.size() <= 1) {
    		return intervals;
    	}
    	List<Interval> results = new ArrayList<>();
    	Comparator<Interval> comparator = new Comparator<Interval>() {
    		public int compare(Interval o1, Interval o2) {
    			if(o1 == null && o2 == null) {
    				return 0;
    			} else if(o1 == null) {
    				return -1;
    			} else if(o2 == null) {
    				return 1;
    			}
    			return o1.start - o2.start;
    		}
    	};
    	Collections.sort(intervals, comparator);
    	int i=0; 
    	while(i < intervals.size()) {
    		int j = i+1;
    		while(j < intervals.size() && intervals.get(i).end >= intervals.get(j).start) {
    			Interval ii = intervals.get(i), ij = intervals.get(j);
    			ii.end = Math.max(ii.end,ij.end);
    			j++;
    		}
    		results.add(intervals.get(i));
    		i=j;
    	}
    	return results;
    }
}
