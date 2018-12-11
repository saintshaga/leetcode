class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) {
        	return nums.length;
        }
        Set<Integer> allNumbers = new HashSet<>();
        for(int i : nums) {
        	allNumbers.add(i);
        }
        int result = 1;
        while(!allNumbers.isEmpty()) {
        	Iterator<Integer> it = allNumbers.iterator();
        	int currentNum = it.next();
        	int i = currentNum;
        	int resulti = 1;
        	while(!allNumbers.isEmpty() && i!=Integer.MAX_VALUE && allNumbers.contains(++i)) {
        		resulti++;
        		allNumbers.remove(i);
        	}
        	i = currentNum;
        	while(!allNumbers.isEmpty() && i!=Integer.MIN_VALUE && allNumbers.contains(--i)) {
        		resulti++;
        		allNumbers.remove(i);
        	}
        	result = result < resulti ? resulti : result;
        	allNumbers.remove(currentNum);
        }
        return result;
    }
}
