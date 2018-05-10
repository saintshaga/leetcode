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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int i = 0;
        boolean reverse = false;
        while(i < nodes.size()) {
        	int size = nodes.size();
        	List<Integer> level = new ArrayList<>();
        	while(i < size) {
        		TreeNode node = nodes.get(i++);
        		level.add(node.val);
        		if(node.left != null) {
        			nodes.add(node.left);
        		}
        		if(node.right != null) {
        			nodes.add(node.right);
        		}
        	}
        	if(reverse) {
        		Collections.reverse(level);
        	}
        	results.add(level);
        	reverse = !reverse;
        }
        return results;
    }
}
