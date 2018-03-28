class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 2) {
        	return 0;
        }
        int n = s.length();
        int maxLength = 0;
        int[] b = new int[n];
        b[0] = 0;
        for(int i=1; i<n; i++) {
        	if(s.charAt(i) == '(') {
        		b[i] = 0;
        	} else if(s.charAt(i-1) == '(') {
        		b[i] = (i >=2 ? b[i-2] : 0) + 2;
        	} else {
        		b[i] = (i-b[i-1] >=1 && s.charAt(i-b[i-1]-1) == '(') ? b[i-1] + 2 + (i-b[i-1]>=2?b[i-b[i-1]-2]: 0): 0;
        	}
        	if(b[i] > maxLength) {
        		maxLength = b[i];
        	}
        }
        return maxLength;
    }
}
