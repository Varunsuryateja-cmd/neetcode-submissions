class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null, the trees are identical at this branch
        if (p == null && q == null) {
            return true;
        }
        
        // If one node is null and the other is not, or their values don't match, they are not the same
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursively compare the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}