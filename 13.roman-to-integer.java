class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i=0; 
        while(i < s.length()) {
        	char c = s.charAt(i);
        	if(i+1 < s.length() && map.get(c) < map.get(s.charAt(i+1))) {
        		result += map.get(s.charAt(i+1)) - map.get(c);
        		i += 2;
        	} else {
        		result += map.get(c);
        		i++;
        	}
        }
        return result;
    }
}
