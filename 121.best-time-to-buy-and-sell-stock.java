class Solution {
    public int maxProfit(int[] prices) {
    	if(prices.length == 0) {
    		return 0;
    	}
        int max = 0;
        int maxRight = prices[prices.length-1];
        for(int i=prices.length-2; i>=0; i--) {
        	maxRight = Math.max(prices[i], maxRight);
        	max = Math.max(max, maxRight-prices[i]);
        }
        return max;
    }
}
