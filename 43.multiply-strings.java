class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
        	return null;
        }
        if(num1.length() < num2.length()) {
        	return multiply(num2, num1);
        }
        if(num2.length() == 0) {
        	return "";
        }
        String[] mulResult = new String[10];
        mulResult[0] = "0";
        String result = "0";
        for(int i=0; i<num2.length(); i++) {
        	int b = num2.charAt(num2.length()-1-i) - '0';
        	StringBuilder sb = new StringBuilder();
        	if(mulResult[b] != null) {
        		sb.append(mulResult[b]);
        	} else {
        		int additional = 0;
        		for(int j=num1.length()-1; j>=0; j--) {
        			int mul = b * (num1.charAt(j) - '0') + additional;
        			sb.append(mul%10);
        			additional = mul /10;
        		}
        		sb.append(additional == 0 ? "" : "" + additional);
        		sb.reverse();
        		mulResult[b] = sb.toString();
        	}
        	for(int j=0; j<i; j++) {
        		sb.append(0);
        	}
        	result = add(result, sb.toString());
        }
        return result;
    }

    private String add(String num1, String num2) {
    	if(num1.length() < num2.length()) {
    		return add(num2, num1);
    	}
    	StringBuilder sb = new StringBuilder();
    	int additional = 0;
    	int n1 = num1.length(), n2 = num2.length();
    	for(int i=0; i<n1; i++) {
    		int a = num1.charAt(n1-1-i) - '0';
    		int b = n2-1-i >= 0 ? (num2.charAt(n2-1-i) - '0') : 0;
    		int c = a+b+additional;
    		sb.append(c%10);
    		additional = c/10;
    	}
		sb.append(additional == 0 ? "" : "" + additional);
		sb.reverse();
    	return sb.toString();
    }
}
