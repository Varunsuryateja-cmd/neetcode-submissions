/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private static final String NULL_MARKER = "N";
    private static final String DELIMITER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_MARKER).append(DELIMITER);
            return;
        }
        sb.append(node.val).append(DELIMITER);
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(DELIMITER);
        int[] index = {0};
        return deserializeHelper(tokens, index);
    }

    private TreeNode deserializeHelper(String[] tokens, int[] index) {
        if (index[0] >= tokens.length || tokens[index[0]].equals(NULL_MARKER)) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(tokens[index[0]++]));
        node.left = deserializeHelper(tokens, index);
        node.right = deserializeHelper(tokens, index);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));