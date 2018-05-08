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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) {
        	return new ArrayList<>();
        }
        List<Integer> nums = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        return generateTrees(nums);
    }

    private List<TreeNode> generateTrees(List<Integer> nums) {
    	List<TreeNode> results = new ArrayList<>();
    	if(nums.size() == 0) {
    		results.add(null);
    		return results;
    	} else if(nums.size() == 1) {
    		results.add(new TreeNode(nums.get(0)));
    		return results;
    	}
    	for(int i=0; i<nums.size(); i++) {
    		List<TreeNode> left = generateTrees(nums.subList(0,i));
    		List<TreeNode> right;
    		if(i == nums.size()-1) {
    			right = generateTrees(new ArrayList<>());
    		} else {
	    		right = generateTrees(nums.subList(i+1, nums.size()));
    		}
    		for(TreeNode l : left) {
    			for(TreeNode r : right) {
    				TreeNode root = new TreeNode(nums.get(i));
    				root.left = l;
    				root.right = r;
    				results.add(root);
    			}
    		}
    	}
    	return results;
    }
}
