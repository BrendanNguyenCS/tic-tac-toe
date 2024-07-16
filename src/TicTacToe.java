/**
 * A tic-tac-toe solver.
 * Values will be limited to -1 or 1 for each player or 0 if a tile hasn't been used yet.
 */
public class TicTacToe {
    /**
     * Checks if there are any moves left available on the given board.
     * @param board the 2d array representing the game
     * @return true if there are moves available, false otherwise
     */
    public boolean anyMovesLeft(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns whether there is a winner of the game.
     */
    public boolean isGameOver(int[][] board) {
        return anyMovesLeft(board);
    }

    /**
     * Checks if there is a winner on the given board.
     * @return true if there is a winner on the board, false otherwise
     */
    public boolean checkWinner(int[][] board) {
        // check if there's a horizontal win
        return checkHorizontal(board) || checkVertical(board) || checkDiagonal(board) || checkCorners(board);
    }

    /**
     * Checks for any horizontal wins.
     */
    private boolean checkHorizontal(int[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            boolean isHorizontal = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    isHorizontal = false;
                    break;
                }
                if (board[i][j] != board[i][j + 1]) {
                    isHorizontal = false;
                    break;
                }
            }
            if (isHorizontal) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for any vertical wins.
     */
    private boolean checkVertical(int[][] board) {
        for (int i = 0; i < board.length - 1; i++) {
            boolean isVertical = true;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    isVertical = false;
                    break;
                }
                if (board[i][j] != board[i + 1][j]) {
                    isVertical = false;
                    break;
                }
            }
            if (isVertical) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for any diagonal wins
     * @param board
     * @return
     */
    private boolean checkDiagonal(int[][] board) {
        // check diagonal from top left to bottom right
        for (int i = 0; i < board.length - 1; i++) {
            boolean isDiagonal = true;
            for (int j = 0; j < board[0].length - 1; j++) {
                // ignore anything that isn't in the diagonal
                if (i != j) {
                    continue;
                }
                if (board[i][j] == 0) {
                    isDiagonal = false;
                    break;
                }
                if (board[i][j] != board[i + 1][j + 1]) {
                    isDiagonal = false;
                    break;
                }
            }
            if (isDiagonal) {
                return true;
            }
        }

        // check diagonal from bottom left to top right
        for (int i = 0; i < board.length - 1; i++) {
            boolean isDiagonal = true;
            for (int j = board.length - 1; j > 0; j--) {
                if (4 - i - 1 != j) {
                    continue;
                }
                if (board[i][j] == 0) {
                    isDiagonal = false;
                    break;
                }
                if (board[i][j] != board[i + 1][j - 1]) {
                    isDiagonal = false;
                    break;
                }
            }
            if (isDiagonal) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for any corner wins.
     */
    private boolean checkCorners(int[][] board) {
        return board[0][0] != 0 && board[0][0] == board[3][0] && board[3][0] == board[3][3] && board[3][3] == board[0][3];
    }
}
