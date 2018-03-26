class Solution {
    public String intToRoman(int num) {
        char[] chars = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        for(int i=3; i>=0; i--) {
        	int pow = (int)Math.pow(10, i);
        	int digit = num/pow;
        	num %= pow;
        	if(digit == 0) {
        		continue;
        	}
        	if(digit < 4) {
        		sb.append(repeatChar(chars[2*i], digit));
        	} else if(digit == 4) {
        		sb.append(chars[2*i]);
        		sb.append(chars[2*i+1]);
        	} else if(digit < 9 ) {
        		sb.append(chars[2*i+1]);
        		sb.append(repeatChar(chars[2*i], digit - 5));
        	} else if(digit == 9) {
        		sb.append(chars[2*i]);
        		sb.append(chars[2*i+2]);
        	}
        }
        return sb.toString();
    }

    private String repeatChar(char c, int n) {
    	StringBuilder sb = new StringBuilder();
    	int i=0;
    	while(i++ < n) {
    		sb.append(c);
    	}
    	return sb.toString();
    }

}
