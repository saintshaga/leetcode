class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
        	return true;
        }
        int i=0, j=s.length() - 1;
        while(i < j) {
        	char ci = s.charAt(i);
        	char cj = s.charAt(j);
        	if(!isAlphaNumberic(ci)) {
        		i++;
        	} else if(!isAlphaNumberic(cj)) {
        		j--;
        	} else if(ci == cj || isEqualsAlpha(ci,cj)) {
        		i++;
        		j--;
        	} else {
        		return false;
        	}
        }
        return true;
    }

    private boolean isAlphaNumberic(char c) {
    	return isAlpha(c) || isNumberic(c);
    }

    private boolean isAlpha(char c) {
    	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private boolean isNumberic(char c) {
    	return c >= '0' && c <= '9';
    }

    private boolean isEqualsAlpha(char a, char b) {
    	return isAlpha(a) && isAlpha(b) & Math.abs(a-b) == Math.abs('A' - 'a');
    }
}
