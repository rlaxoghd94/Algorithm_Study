
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.right.right = new TreeNode(11);
		
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.left = new TreeNode(1);
		
		System.out.println(pathSum(root, 8));
	}

	/*
	 * Approach:
	 *    (Condition: sum must occur downward and the starting sum node doesn't have to be the root node)
	 *    Therefore, generally speaking, two types of recursive must occur
	 *    	1. calculation starting at a given node				- int:nonRootPathSum()
	 *    	2. calculation started at a previous parent node	- int:pathSum()
	 */
	public static int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		
		return nonRootPathSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	private static int nonRootPathSum(TreeNode node, int sum) {
		if (node == null)
			return 0;
		
		return (node.val == sum? 1 : 0) + nonRootPathSum(node.left, sum - node.val) + nonRootPathSum(node.right, sum - node.val);
	}

	public static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			this.val = x;
		}
	}
}
