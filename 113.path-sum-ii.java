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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if(root == null) {
        	return results;
        }
        if(root.left == null && root.right == null) {
        	if(root.val == sum) {
        		List<Integer> r = new LinkedList<>();
        		r.add(root.val);
        		results.add(r);
        	}
        	return results;
        }
        List<List<Integer>> left = null, right = null;
        if(root.left != null) {
        	left = pathSum(root.left, sum-root.val);
        }
        if(root.right != null) {
        	right = pathSum(root.right, sum-root.val);
        }
        summarize(results, left, root.val);
        summarize(results, right, root.val);
        return results;

    }

	private void summarize(List<List<Integer>> results, List<List<Integer>> r, int val) {
		if(r != null) {
			for(List<Integer> ri : r) {
				ri.add(0, val);
				results.add(ri);
			}
		}
	}
}
