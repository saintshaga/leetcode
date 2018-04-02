class Solution {
    public String countAndSay(int n) {
        if(n < 1) {
        	return "";
        }
        String[] results = new String[n];
        results[0] = "1";
        for(int i=1; i<n; i++) {
        	StringBuilder sb = new StringBuilder();
        	int j=0;
        	String s = results[i-1];
        	while(j < s.length()) {
        		char c = s.charAt(j++);
        		int num = 1;
        		while(j < s.length() && s.charAt(j) == c) {
        			j++;
        			num++;
        		}
        		sb.append(num);
        		sb.append(c);
        	}
        	results[i] = sb.toString();
        }
        return results[n-1];
    }
}
