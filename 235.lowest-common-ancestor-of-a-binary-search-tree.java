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
        if(p == q) {
        	return p;
        }
        List<TreeNode> pPath = findPath(root, p);
        List<TreeNode> qPath = findPath(root, q);
        int i=0;
        while(i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i)) {
        	i++;
        }
        if(i == 0) {
        	return null;
        }
        return pPath.get(i-1);
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode target) {
    	List<TreeNode> results = new ArrayList<>();
    	TreeNode node = root;
    	while(node != target && node != null) {
    		results.add(node);
    		if(target.val <= node.val) {
    			node = node.left;
    		} else {
    			node = node.right;
    		}
    	}
    	if(node != null) {
    		results.add(target);
    	}
    	return results;
    }
}
