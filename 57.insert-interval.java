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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> results = new ArrayList<>();
        if(intervals.size() == 0) {
        	results.add(newInterval);
        	return results;
        }
        int pos  = binarySearch(intervals, newInterval.start);
        int i = 0;
        while(i < intervals.size()) {
			if(i == pos - 1) {
        		Interval ii = intervals.get(i);
        		if(ii.end < newInterval.start) {
        			results.add(ii);
        		} else {
        			newInterval.start = ii.start;
        			newInterval.end = Math.max(ii.end, newInterval.end);
        		}
        		i++;
        	} else if(i == pos) {
        		while(i < intervals.size() && newInterval.end >= intervals.get(i).start) {
        			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
        			i++;
        		}
        		results.add(newInterval);
        		if(i < intervals.size()) {
        			results.add(intervals.get(i++));
        		}
        	} else {
        		results.add(intervals.get(i++));
        	}
        }
        if(intervals.size() == pos) {
        	results.add(newInterval);
        }
        return results;
    }

    private int binarySearch(List<Interval> intervals, int t) {
        int l=0, h=intervals.size()-1, mid=0;
        while(l<=h) {
        	mid = (l+h)/2;
        	if(intervals.get(mid).start == t) {
        		return mid;
        	}
        	if(intervals.get(mid).start < t) {
        		l = mid+1;
        	} else {
        		h = mid - 1;
        	}
        }
        return t <= intervals.get(mid).start ? mid : mid+1;
    }
}
