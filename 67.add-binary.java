class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()) {
        	return addBinary(b,a);
        }
        int n = a.length();
        int m = b.length();
        int additional = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	char ca = a.charAt(n-1-i);
        	char cb = i<m ? b.charAt(m-1-i) : '0';
        	int cc = (ca-'0') + (cb-'0') + additional;
        	sb.append(cc%2 == 0? '0' : '1');
        	additional = cc/2;
        }
        if(additional%2 != 0) {
        	sb.append('1');
        }
        return sb.reverse().toString();
    }
}
