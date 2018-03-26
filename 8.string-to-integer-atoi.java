class Solution {
    public int myAtoi(String str) {
    	if(str == null || str.length() == 0) {
    		return 0;
    	}
        long result  = 0l;
        int sign = 1;
        int i=0;
        boolean hasNumber = false;
        while(i < str.length()) {
        	char c = str.charAt(i);
        	if(hasNumber && !isNumber(c)) {
        		return sign * ((int)result);
        	}
        	if(c == '+') {
        		hasNumber = true;
        		sign = 1;
        	} else if(c == '-') {
        		hasNumber = true;
        		sign = -1;
        	} else if(isNumber(c)) {
        		hasNumber = true;
        		result = result * 10 + (c-'0');
        		if(exceed(result * sign)) {
        			return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        		}
        	} else if(c != ' ') {
        		return 0;
        	}
        	i++;
        }
        return (int)result * sign;
    }

    private boolean isNumber(char c) {
    	return c >= '0' && c <= '9';
    }

    private boolean exceed(long l) {
    	return l > (long)Integer.MAX_VALUE || l < (long)Integer.MIN_VALUE; 
    }
}
