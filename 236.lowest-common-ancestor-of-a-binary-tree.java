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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
        	return null;
        }
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        if(!findPath(root, p, pPath)) {
        	return null;
        }
        if(!findPath(root, q, qPath)) {
        	return null;
        }
        int i=0;
        while(i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
        	i++;
        }
        return pPath.get(i-1);
    }

    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> paths) {
    	if(root == null) {
    		return false;
    	}
    	if(root == p) {
    		paths.add(root);
    		return true;
    	}
    	paths.add(root);
    	if(findPath(root.left, p, paths)) {
    		return true;
    	}
    	if(findPath(root.right, p, paths)) {
    		return true;
    	}
    	paths.remove(paths.size()-1);
    	return false;
    }
}
