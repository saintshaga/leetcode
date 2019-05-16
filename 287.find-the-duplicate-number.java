class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length <= 1) {
        	return -1;
        }
        int turtle = nums[0];
        int rabit = nums[0];
        do {
        	turtle = nums[turtle];
        	rabit = nums[nums[rabit]];
        } while (turtle != rabit);
        int num1 = nums[0];
        int num2 = turtle;
        while(num1 != num2) {
        	num1 = nums[num1];
        	num2 = nums[num2];
        }
        return num1;
    }
}
