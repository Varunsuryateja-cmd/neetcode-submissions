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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: if the main tree is null, subRoot cannot be a subtree
        if (root == null) {
            return false;
        }
        
        // If the trees match starting from the current root, return true
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // Otherwise, recursively check the left and right subtrees of root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes are null -> identical
        if (p == null && q == null) {
            return true;
        }
        // One is null or values don't match -> not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively check both left and right children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}