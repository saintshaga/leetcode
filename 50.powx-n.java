class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
        	return 1;
        }
        List<Double> results = new ArrayList<>();
        while(n != 1 && n != -1) {
        	results.add(n % 2 == 0 ? null : x);
        	n /= 2;
        }
        results.add(x);
        for(int i=results.size()-2; i>=0; i--) {
        	Double ri = results.get(i);
        	Double ri2 = results.get(i+1) * results.get(i+1);
        	results.set(i, ri == null ? ri2 : ri2*x);
        }
        return n > 0 ? results.get(0) : 1.0/results.get(0);
    }
}
