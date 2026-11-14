class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.word = w;
        }

        List<String> result = new ArrayList<>();
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int idx = board[r][c] - 'a';
                if (root.children[idx] != null) {
                    dfs(board, r, c, root, result);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> result) {
        char ch = board[r][c];
        TrieNode curr = parent.children[ch - 'a'];

        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null; // Avoid duplicate additions
        }

        board[r][c] = '#'; // Mark as visited

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != '#') {
                if (curr.children[board[nr][nc] - 'a'] != null) {
                    dfs(board, nr, nc, curr, result);
                }
            }
        }

        board[r][c] = ch; // Restore state
        
        // Optional optimization: prune empty branches to speed up subsequent searches
        boolean isEmpty = true;
        for (TrieNode child : curr.children) {
            if (child != null) {
                isEmpty = false;
                break;
            }
        }
        if (isEmpty) {
            parent.children[ch - 'a'] = null;
        }
    }
}