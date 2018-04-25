class Solution {
    public String getPermutation(int n, int k) {
    	List<Integer> nums = new ArrayList<>();
    	for(int i=0; i<n; i++) {
    		nums.add(i+1);
    	}
    	return getPermutation(nums, k-1);
    }

    private String getPermutation(List<Integer> nums, int k) {
    	if(nums.size() == 1) {
    		return String.valueOf(nums.get(0));
    	}
    	int n = nums.size();
    	int fn = factorial(n-1);
    	int i = k/fn;
    	int currentNum = nums.remove(i);
    	return (String.valueOf(currentNum) + getPermutation(nums, k % fn));
    }

    private int factorial(int n) {
    	int result = 1;
    	while(n >= 1) {
    		result *= n;
    		n--;
    	}
    	return result;
    }

}
