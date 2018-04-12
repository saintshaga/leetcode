class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0) {
    		return false;
    	}
        int n = 0;
        int xx = x;
        do {
        	n++;
        	xx /= 10;
        } while(xx != 0);
        for(int i=0; i<n/2; i++) {
        	int ni = n-2*i;
        	int last = x%10;
        	int first = x/((int)Math.pow(10, ni-1));
        	if(first != last) {
        		return false;
        	}
        	x %= ((int)Math.pow(10, ni-1));
        	x /= 10;
        }
        return true;
    }
}
