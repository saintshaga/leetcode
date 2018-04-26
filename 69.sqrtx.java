class Solution {
    public int mySqrt(int x) {
        if(x==0 || x == 1) {
        	return x;
        }
        int r = 1;
        while(x/r > r){
        	r++;
        }
        return x/r == r ? r : r-1;
    }
}
