class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k); // Fixed: changed inOrder to inorder
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inorder(node.left, k);

        // Process current node
        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        // Traverse right subtree (only if we haven't found it yet)
        if (count < k) {
            inorder(node.right, k);
        }
    }
}