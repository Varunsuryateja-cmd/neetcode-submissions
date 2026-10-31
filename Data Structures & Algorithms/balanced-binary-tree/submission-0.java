/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).isBalanced;
    }

    // Helper class to return both the height and balance status from a subtree
    private class TreeInfo {
        int height;
        boolean isBalanced;

        TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    private TreeInfo dfs(TreeNode root) {
        // Base case: An empty tree is balanced and has a height of 0
        if (root == null) {
            return new TreeInfo(0, true);
        }

        // Recursively get height and balance status of left and right subtrees
        TreeInfo left = dfs(root.left);
        TreeInfo right = dfs(root.right);

        // Current node is balanced if left & right subtrees are balanced 
        // and their heights differ by at most 1
        boolean currentBalanced = left.isBalanced && right.isBalanced 
                                  && Math.abs(left.height - right.height) <= 1;

        // Current height is 1 plus the taller of the two subtrees
        int currentHeight = Math.max(left.height, right.height) + 1;

        return new TreeInfo(currentHeight, currentBalanced);
    }
}