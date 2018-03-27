class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
        	return "";
        }
        String result = strs[0];
        for(int i=1; i<strs.length; i++) {
        	if(isEmpty(result) || isEmpty(strs[i])) {
        		return "";
        	}
        	int j;
        	for(j=0; j<result.length() && j<strs[i].length(); j++) {
        		if(result.charAt(j) != strs[i].charAt(j)) {
        			break;
        		}
        	}
        	result = result.substring(0, j);
        }
        return result;
    }

    private boolean isEmpty(String str) {
    	return str == null || str.length() == 0;
    }
}
