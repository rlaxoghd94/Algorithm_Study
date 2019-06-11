
public class Main {

    static int ans;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
    }

    /*
     * Problem: find the maximum length path within a given binary tree
     * Approach: using DFS algorithm, find and calculate the maximum value using the depth value
     *    Scenarios:
     *       -> Calculation based on a previous node
     *       -> Calculation based on a current node
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        DFS(root, 1);

        return ans;
    }

    public static int DFS(TreeNode root, int depth) {
        if (root == null) {
            // this returns the depth of the node
            return depth - 1;
        } else {
            // finding depth of the node
            int leftDepth = DFS(root.left, depth + 1);
            int rightDepth = DFS(root.right, depth + 1);

            // calculating the max between two scenarios mentioned above
            ans = Math.max(ans, (leftDepth + rightDepth) - (2 * depth) );
            // choose to follow the deepest branch as possible
            return Math.max(leftDepth, rightDepth);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
