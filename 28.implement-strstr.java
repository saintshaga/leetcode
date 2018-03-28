class Solution {
    public int strStr(String haystack, String needle) {
    	if(isEmpty(needle)) {
    		return 0;
    	}
        if(isEmpty(haystack) || needle.length() > haystack.length()) {
        	return -1;
        }
        int n = haystack.length();
        int m = needle.length();
        for(int i=0; i<=n-m; i++) {
        	int j;
        	for(j=0; j<m; j++) {
        		if(haystack.charAt(i+j) != needle.charAt(j)) {
        			break;
        		}
        	}
        	if(j == m) {
        		return i;
        	}
        }
        return -1;
    }

    private boolean isEmpty(String str) {
    	return str == null || str.length() == 0;
    }
}
