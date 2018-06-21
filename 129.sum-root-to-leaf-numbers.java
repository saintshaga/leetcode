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
    public int sumNumbers(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        List<String> results = numbers(root);
        int sum = 0;
        for(String i:results) {
        	sum += Integer.valueOf(i);
        }
        return sum;
    }

    private List<String> numbers(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	List<String> results = new ArrayList<>();
    	List<String> left = numbers(root.left);
    	List<String> right = numbers(root.right);
    	if(left != null) {
    		for(String i: left) {
    			results.add(String.valueOf(root.val)+i);
    		}
    	}
    	if(right != null) {
    		for(String i:right) {
    			results.add(String.valueOf(root.val)+i);
    		}
    	}
    	if(results.isEmpty()) {
    		results.add(String.valueOf(root.val));
    	}
    	return results;
    }
}
