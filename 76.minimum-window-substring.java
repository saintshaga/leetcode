class Solution {
    public String minWindow(String s, String t) {
        if(t == null || s == null || s.length() == 0 || t.length() == 0) {
        	return "";
        }
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
        	int count = tMap.getOrDefault(t.charAt(i), 0);
        	tMap.put(t.charAt(i), count + 1);
        }
        int fullSize = tMap.size();
        Map<Character, Integer> sMap = new HashMap<>();
        int fullCount = 0;
        int left = 0, right = 0;
        int startIndex = 0, minSize = Integer.MAX_VALUE;
        while(right < s.length()) {
        	char c = s.charAt(right);
        	if(tMap.containsKey(c)) {
	        	int count = sMap.getOrDefault(c, 0);
    	    	sMap.put(c, count+1);
    	    	if(tMap.get(c) == count+1) {
    	    		fullCount++;
    	    	}
    	    	while(left <= right && fullCount == fullSize) {
    	    		if(right-left+1 < minSize) {
    	    			minSize = right-left+1;
    	    			startIndex = left;
    	    		}
    	    		char leftc = s.charAt(left);
    	    		if(sMap.containsKey(leftc)) {
    	    			sMap.put(leftc, sMap.get(leftc)-1);
    	    			if(sMap.get(leftc) < tMap.get(leftc)) {
    	    				fullCount--;
    	    			}
    	    		}
    	    		left++;
    	    	}
        	}
    		right++;

        }
        return minSize > s.length() ? "" : s.substring(startIndex, startIndex+minSize);
    }
}
