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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }
        
        // A node is "good" if its value is greater than or equal to the maximum value seen so far on the path
        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val; // Update maxSoFar for the recursive children
        }
        
        // Traverse left and right subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);
        
        return count;
    }
}