class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0) {
        	return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 1;
        map.put(s.charAt(0), 0);
        int st = 0;
        for(int i=1; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(map.containsKey(c) && map.get(c) >= st) {
        		st = map.get(c) + 1;
        	}
        	map.put(c, i);
        	maxLength = Math.max(maxLength, i-st+1);
        }
        return maxLength;
    }
}
