class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1) {
        	return 0;
        }
        int n = s.length();
        Map<Character, Integer> iOfChar = new HashMap<>();
        int maxLength = 0, st = 0;
        for(int i=0; i<n; i++) {
        	char c = s.charAt(i);
        	Integer pos = iOfChar.get(c);
        	if(pos == null || pos < st) {
        		iOfChar.put(c, i);
        		maxLength = Math.max(maxLength, i-st+1);
        	} else {
        		st = pos + 1;
        		iOfChar.put(c, i);
        	}
        }
        return maxLength;
    }
}
