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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
        	List<TreeNode> children = new ArrayList<>();
        	List<Integer> values = new ArrayList<>();
        	for(int i=0; i<nodes.size(); i++) {
        		TreeNode current = nodes.get(i);
        		values.add(current.val);
        		if(current.left != null) {
        			children.add(current.left);
        		}
        		if(current.right != null) {
        			children.add(current.right);
        		}
        	}
        	results.add(values);
        	nodes = children;
        }
        return results;
    }
}
