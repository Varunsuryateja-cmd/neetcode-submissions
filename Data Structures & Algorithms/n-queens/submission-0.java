

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }

        backtrack(0, n, board, result);
        return result;
    }

    private void backtrack(int col, int n, char[][] board, List<List<String>> result) {
        if (col == n) {
            List<String> layout = new ArrayList<>(n);
            for (int r = 0; r < n; r++) {
                layout.add(new String(board[r]));
            }
            result.add(layout);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, n, board)) {
                board[row][col] = 'Q';
                backtrack(col + 1, n, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, int n, char[][] board) {
        // Check left in the same row
        for (int c = 0; c < col; c++) {
            if (board[row][c] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Check lower-left diagonal
        for (int r = row + 1, c = col - 1; r < n && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }
}