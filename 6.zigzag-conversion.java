class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() <= 1 || numRows <= 1) {
        	return s;
        }
        StringBuilder sb = new StringBuilder();
        int columns = s.length() / (2*numRows -2) + 1;
        for(int i=0; i<numRows; i++) {
        	for(int j=0; j<columns; j++) {
        		int index = j*(2*numRows - 2) + i;
        		if(index < s.length()) {
	        		sb.append(s.charAt(index));
        		}
        		index = 2*(numRows-1)*(j+1)-i;
        		if(i>0 && i<numRows-1 && index < s.length()) {
        			sb.append(s.charAt(index));
        		}
        	}
        }
        return sb.toString();
    }
}
