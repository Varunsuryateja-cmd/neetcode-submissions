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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        calculatePathSum(root);
        return maxSum;
    }

    private int calculatePathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the maximum path sum from left and right subtrees.
        // We use Math.max(0, ...) to ignore negative paths since they decrease the overall path sum.
        int leftMax = Math.max(0, calculatePathSum(node.left));
        int rightMax = Math.max(0, calculatePathSum(node.right));

        // Calculate the maximum path sum passing *through* the current node as the "highest" node
        int currentPathSum = node.val + leftMax + rightMax;

        // Update the global maximum path sum found so far
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum sum extending outward from the current node to its parent (can only choose one branch)
        return node.val + Math.max(leftMax, rightMax);
    }
}