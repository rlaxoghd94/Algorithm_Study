import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

		System.out.println(isSymmetric(root));
	}

	/*
	 * Approach: Using BFS traversing, store all TreeNodes with the same depth/level
	 * and check symmetry per level
	 */
	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> bfsQueue = new LinkedList<TreeNode>();
		bfsQueue.add(root);

		int levelSize = 0;
		TreeNode temp;
		List<Integer> singleLevel;
		while (!bfsQueue.isEmpty()) {
			levelSize = bfsQueue.size() - 1;
			singleLevel = new ArrayList<Integer>();
			while (levelSize-- >= 0) {
				// this is where all nodes with the same depth are stored into the queue
				temp = bfsQueue.poll();
				if (temp == null) {
					singleLevel.add(null);
				} else {
					singleLevel.add(temp.val);
					bfsQueue.offer(temp.left);
					bfsQueue.offer(temp.right);
				}
			}

			if (!isSymmetric(singleLevel))
				return false;

			singleLevel = null;
		}
		return true;
	}

	public static boolean isSymmetric(List<Integer> singleLevel) {
		int left = 0, right = singleLevel.size() - 1;

		while (left < right) {
			if (singleLevel.get(left) != singleLevel.get(right))
				return false;

			left++;
			right--;
		}
		return true;
	}

	public static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			this.val = x;
		}
	}
}