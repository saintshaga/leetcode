class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int i = x;
        StringBuilder sb = new StringBuilder();
        do {
        	sb.append(Math.abs(i%10));
        	i /= 10;
        } while(i != 0);
        String r = sb.toString();
        String maxInteger = String.valueOf(0x7fffffff);
        String minInteger = String.valueOf(0x80000000).substring(1);
        if(sign > 0 && r.length() == maxInteger.length() && r.compareTo(maxInteger) > 0) {
        	return 0;
        }
        if(sign < 0 && r.length() == minInteger.length() && r.compareTo(minInteger) > 0) {
        	return 0;
        }
        int result = 0;
        for(int j=0; j<r.length(); j++) {
        	result = result * 10 + (r.charAt(j) - '0');
        }
        return result * sign;

    }
}
