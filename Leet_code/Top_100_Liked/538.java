public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(0);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(1);

        TreeNode ans = convertBST(root);
    }

    static int prev = 0;
    public static TreeNode convertBST(TreeNode root) {
        DFS(root);
        return root;
    }

    public static void DFS(TreeNode root) {
        if (root == null)
            return;

        DFS(root.right);
        root.val += prev;
        prev = root.val;
        DFS(root.left);
    }

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
