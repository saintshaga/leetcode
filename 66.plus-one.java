class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) {
        	return digits;
        }
        boolean plus = true;
        for(int i=digits.length-1; i>=0; i--) {
        	if(plus && digits[i] < 9) {
        		digits[i] += 1;
        		plus = false;
        	} else if(plus && digits[i] == 9) {
        		digits[i] = 0;
        	} else {
        		break;
        	}
        }
        if(plus) {
        	int[] results  = new int[digits.length + 1];
        	results[0] = 1;
        	return results;
        }
        return digits;
    }
}
