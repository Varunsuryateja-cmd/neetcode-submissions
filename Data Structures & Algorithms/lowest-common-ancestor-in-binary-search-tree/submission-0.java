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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;

        while (curr != null) {
            // If both p and q are greater than the current node, LCA must be in the right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            // If both p and q are smaller than the current node, LCA must be in the left subtree
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            // We have found the split point, which is our Lowest Common Ancestor
            else {
                return curr;
            }
        }

        return null;
    }
}