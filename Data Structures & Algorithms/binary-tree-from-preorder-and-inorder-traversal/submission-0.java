class Solution {
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Populate the hash map for O(1) lookups of inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    
    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree, return null
        if (left > right) {
            return null;
        }
        
        // Select the current root value from the preorder traversal and advance the index
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of this root in the inorder traversal to split left and right subtrees
        int mid = inorderIndexMap.get(rootValue);
        
        // Recursively build the left and right subtrees
        root.left = arrayToTree(preorder, left, mid - 1);
        root.right = arrayToTree(preorder, mid + 1, right);
        
        return root;
    }
}