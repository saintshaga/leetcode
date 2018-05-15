/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
        	return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int st, int ed) {
    	if(st > ed) {
    		return null;
    	} else if(st == ed) {
    		return new TreeNode(nums[st]);
    	}
    	int mid = (st+ed+1)/2;
    	TreeNode p = new TreeNode(nums[mid]);
    	p.left = sortedArrayToBST(nums, st, mid-1);
    	p.right = sortedArrayToBST(nums, mid+1, ed);
    	return p;
    }
}
