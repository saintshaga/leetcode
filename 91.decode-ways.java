class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || !isValid(s.charAt(0))) {
        	return 0;
        }
        int[] c = new int[s.length() + 1];
        c[0] = 1;
        c[1] = 1;
        for(int i=2; i<=s.length(); i++) {
        	int now = s.charAt(i-1) - '0';
        	int last = s.charAt(i-2) - '0';
        	c[i] = 0;
        	if(now != 0) {
	        	c[i] += c[i-1];
        	}
        	int combine = last*10+now;
        	if(last != 0 && combine <= 26 && combine >= 1) {
        		c[i] += c[i-2];
        	}
        	if(c[i] == 0) {
        		return 0;
        	}
        }
        return c[s.length()];
    }

    private boolean isValid(char c) {
    	return c >= '1' && c <= '9';
    }
}
