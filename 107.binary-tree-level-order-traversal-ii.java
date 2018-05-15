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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new LinkedList<>();
        if(root == null) {
        	return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	List<Integer> r = new ArrayList<>();
        	while(size-- > 0) {
        		TreeNode p = queue.poll();
        		r.add(p.val);
        		if(p.left != null) {
        			queue.offer(p.left);
        		}
        		if(p.right != null) {
        			queue.offer(p.right);
        		}
        	}
        	results.add(0,r);
        }
        return results;
    }
}
