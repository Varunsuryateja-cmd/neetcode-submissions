class Solution {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
                || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char original = board[r][c];
        board[r][c] = '#'; // mark as visited in current path

        for (int[] d : DIRS) {
            if (dfs(board, word, r + d[0], c + d[1], idx + 1)) {
                board[r][c] = original;
                return true;
            }
        }

        board[r][c] = original; // backtrack
        return false;
    }
}