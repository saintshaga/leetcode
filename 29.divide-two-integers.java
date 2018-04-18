class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0x80000000 && divisor == -1) {
        	return 0x7fffffff;
        }
        boolean negetive = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        int result = 0;
        while(canDivide(dividend, divisor, negetive)) {
        	int added = 1;
	        int i = divisor;
	        while(legalForDouble(i) && canDivide(dividend, i+i, negetive)) {
	        	i = i + i;
	        	added = added + added;
	        }
	        dividend = divide(dividend, i, negetive);
	        result = addResult(result, added, negetive);
        }
        return result;
    }

    private boolean canDivide(int a, int b, boolean negetive) {
    	return (a > 0 && divide(a,b,negetive) >= 0) || (a < 0 && divide(a,b,negetive) <= 0);
    }

    private int divide(int a, int b, boolean negetive) {
    	return negetive ? a + b : a - b;
    }

    private int addResult(int result, int added, boolean negetive) {
    	return negetive ? result-added : result + added;
    }

    private boolean legalForDouble(int x) {
    	return x >= 0xC0000000 && x < 0x40000000;
    }
}
