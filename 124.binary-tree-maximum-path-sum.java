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
    public int maxPathSum(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        Map<TreeNode, Integer> map1 = new HashMap<>();
        Map<TreeNode, Integer> map2 = new HashMap<>();
        int max = calculateMaxPath(root, map1, map2);
        for(int i : map1.values()) {
        	max = Math.max(max, i);
        }
        return max;
    }

    public int calculateMaxPath(TreeNode root, Map<TreeNode, Integer> map1, Map<TreeNode, Integer> map2) {
    	if(root == null) {
    		return 0;
    	}
    	if(map2.containsKey(root)) {
    		return map2.get(root);
    	}
    	int byPass = root.val;
    	int left = 0;
    	int right = 0;
    	if(root.left != null && calculateMaxPath(root.left, map1, map2) > 0) {
    		left = calculateMaxPath(root.left, map1, map2);
    	}
    	if(root.right != null && calculateMaxPath(root.right, map1, map2) > 0) {
    		right = calculateMaxPath(root.right, map1, map2);
    	}
    	byPass += Math.max(left, right);
    	map1.put(root, root.val + left + right);
    	map2.put(root, byPass);
    	return byPass;
    }
}
