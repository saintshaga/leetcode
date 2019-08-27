class Solution {
    public int divide(int dividend, int divisor) {
         if(divisor == Integer.MIN_VALUE) {
         	return dividend == divisor ? 1 : 0;
         }
         if(dividend == 0) {
         	return 0;
         }
         boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
         int plus = 0;
         if(dividend == Integer.MIN_VALUE) {
         	dividend = Integer.MAX_VALUE;
         	plus = 1;
         } else {
         	dividend = Math.abs(dividend);
         }
         divisor = Math.abs(divisor);
         if(divisor == 1) {
         	return positive ? dividend : (-dividend-plus);
         }

         int result = 0;
         while(dividend >= divisor) {
         	int i = 1, lastI = 0;
         	int currentDivisor = divisor, lastDivisor = 1;
         	while(dividend >= currentDivisor && currentDivisor > 0) {
         		lastDivisor = currentDivisor;
         		lastI = i;
         		currentDivisor = currentDivisor << 1;
         		i = i << 1;
         	}
         	result += lastI;
         	dividend -= lastDivisor;
         	if(plus > 0) {
         		dividend += plus;
         		plus = 0;
         	}
         }
         return positive ? result : -result;

    }
}
