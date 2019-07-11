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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        Map<TreeNode, Integer> heigthMap = new HashMap<>();
        List<Integer> diameter = new ArrayList<>();
        diameter.add(-1);
        heigthOfTree(root, heigthMap, diameter);
        return diameter.get(0);
    }

    private int heigthOfTree(TreeNode root, Map<TreeNode,Integer> map, List<Integer> diameter) {
    	if(root == null) {
    		return 0;
    	}
    	if(!map.containsKey(root)) {
	    	int left = heigthOfTree(root.left, map, diameter);
    		int right = heigthOfTree(root.right, map, diameter);
    		map.put(root, Math.max(left, right) + 1);
    		diameter.set(0, Math.max(diameter.get(0), left+right));
    	}
    	return map.get(root);
    }
}
