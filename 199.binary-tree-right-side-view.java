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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
        	results.add(nodes.get(nodes.size()-1).val);
        	List<TreeNode> temp = new ArrayList<>();
        	for(TreeNode node : nodes) {
        		if(node.left != null) {
        			temp.add(node.left);
        		}
        		if(node.right != null) {
        			temp.add(node.right);
        		}
        	}
        	nodes = temp;
        }
        return results;
    }
}
