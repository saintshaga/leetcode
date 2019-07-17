class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        char[] chars = s.toCharArray();
        int[] l = new int[chars.length];
        l[0] = 0;
        int maxLength = 0;
        for(int i=1; i<chars.length; i++) {
        	char c = chars[i];
        	int pair = i-l[i-1]-1;
        	if(c == ')' && pair >= 0 && chars[pair] == '(') {
        		l[i] = l[i-1] + 2;
        		if(pair-1 >= 0) {
        			l[i] += l[pair-1];
        		}
        	} else {
        		l[i] = 0;
        	}
        	maxLength = Math.max(l[i], maxLength);
        }
        return maxLength;
    }
}
