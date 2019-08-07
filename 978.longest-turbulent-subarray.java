class Solution {
    public int maxTurbulenceSize(int[] A) {
        if(A == null || A.length == 0) {
        	return 0;
        }
        int max = 1;
        int should = 0; //1 a[i] > a[i-1], -1 a[i] < a[i-1]
        int st = 0;
        for(int i=1; i<A.length; i++) {
        	if(A[i] == A[i-1]) {
        		st = i;
        		should = 0;
        	} else if(should == 0) {
        		should = A[i] > A[i-1] ? -1 : 1;
        	} else if((should > 0 && A[i] > A[i-1]) || (should < 0 && A[i] < A[i-1])) {
        		should *= -1;
        	} else {
        		st = i-1;
        		should = A[i] > A[i-1] ? -1 : 1;
        	}
        	max = Math.max(max, i-st+1);
        }
        return max;
    }
}
