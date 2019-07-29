class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0 || k < 0) {
        	return 0;
        }
        if(k == 0) {
        	return longestRepeatedString(s);
        }
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for(int i=0; i < s.length(); i++) {
        	if(set.contains(s.charAt(i))) {
        		continue;
        	}
        	set.add(s.charAt(i));
        	maxLength = Math.max(maxLength, characterReplaceMent(s, k, s.charAt(i)));
        }
        return maxLength;
    }

    private int longestRepeatedString(String s) {
    	int result = 1;
    	int prevResult = 1;
    	for(int i=1; i<s.length(); i++) {
    		if(s.charAt(i) == s.charAt(i-1)) {
    			int current = prevResult + 1;
    			result = Math.max(result, current);
    			prevResult = current;
    		} else {
    			prevResult = 1;
    		}
    	}
    	return result;
    }

    private int characterReplaceMent(String s, int k, char target) {
    	int maxLength = 0;
    	Queue<Integer> queue = new LinkedList<>();
    	int st = 0;
    	for(int i=0; i<s.length(); i++) {
    		if(target != s.charAt(i)) {
    			if(queue.size() == k) {
    				st = queue.poll() + 1;
    			}
    			queue.offer(i);
    		}
    		maxLength = Math.max(maxLength, i-st+1);
    	}
    	return maxLength;
    }
}
