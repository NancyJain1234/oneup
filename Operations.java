/**
* @Filename - Operations.java
* @Description - this will contain list of operations of 2048 Game
* @Author - Nancy Jain
*/

import java.util.Random;
public class Operations {
    // Initialize board with two tiles
    private int[][] board;
    private int score;
    private final int SIZE = 4;
    private final int WINNING_TILE = 2048;
    public static boolean gameOver = false;

    public Operations() {
        board = new int[SIZE][SIZE];
        score = 0;
    }

    public int getScore() { 
        return score;
    }

    public Operations(int WINNING_TILE) { 
    WINNING_TILE = WINNING_TILE;
    board = new int[SIZE][SIZE]; 
    score = 0;
    }

    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = 0;
        generateNewTile();
        generateNewTile();
        score = 0;
        gameOver = false;
    }

    // Print board to console
    public void printBoard() {
        System.out.println("\nScore: " + score);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%5d", board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Add a new tile (2 or 4) at a random empty spot
    public void generateNewTile() {
        Random rand = new Random();
        int value = rand.nextInt(10) < 9 ? 2 : 4; // 90% chance for 2, 10% for 4
        int emptyCount = 0;

        // Count empty cells
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0)
                    emptyCount++;

        if (emptyCount == 0) return;

        int pos = rand.nextInt(emptyCount);
        int k = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0) {
                    if (k == pos) {
                        board[i][j] = value;
                        return;
                    }
                    k++;
                }
    }

    // Check if game is over (no moves left)
    public boolean isGameOver() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == 0)
                    return false;

        // Check if any merge is possible
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                if (i < SIZE - 1 && board[i][j] == board[i + 1][j])
                    return false;
                if (j < SIZE - 1 && board[i][j] == board[i][j + 1])
                    return false;
            }
        return true;
    }

    // Check if 2048 tile exists
    public boolean checkForWin() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == WINNING_TILE)
                    return true;
        return false;
    }

    // Move tiles up
    public boolean moveUp() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int[] col = new int[SIZE];
            int idx = 0;
            int lastMerged = -1;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][j] != 0) {
                    if (idx > 0 && col[idx - 1] == board[i][j] && lastMerged != idx - 1) {
                        col[idx - 1] *= 2;
                        score += col[idx - 1];
                        lastMerged = idx - 1;
                        moved |= (i != idx - 1);
                    } else {
                        col[idx++] = board[i][j];
                        moved |= (i != idx - 1);
                    }
                }
            }
            for (int i = 0; i < SIZE; i++)
                board[i][j] = (i < idx) ? col[i] : 0;
        }
        return moved;
    }

    // Move tiles down
    public boolean moveDown() {
        boolean moved = false;
        for (int j = 0; j < SIZE; j++) {
            int[] col = new int[SIZE];
            int idx = SIZE - 1;
            int lastMerged = SIZE;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (idx < SIZE - 1 && col[idx + 1] == board[i][j] && lastMerged != idx + 1) {
                        col[idx + 1] *= 2;
                        score += col[idx + 1];
                        lastMerged = idx + 1;
                        moved |= (i != idx + 1);
                    } else {
                        col[idx--] = board[i][j];
                        moved |= (i != idx + 1);
                    }
                }
            }
            for (int i = SIZE - 1; i >= 0; i--)
                board[i][j] = (i > idx) ? col[i] : 0;
        }
        return moved;
    }

    // Move tiles left
    public boolean moveLeft() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] row = new int[SIZE];
            int idx = 0;
            int lastMerged = -1;
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0) {
                    if (idx > 0 && row[idx - 1] == board[i][j] && lastMerged != idx - 1) {
                        row[idx - 1] *= 2;
                        score += row[idx - 1];
                        lastMerged = idx - 1;
                        moved |= (j != idx - 1);
                    } else {
                        row[idx++] = board[i][j];
                        moved |= (j != idx - 1);
                    }
                }
            }
            for (int j = 0; j < SIZE; j++)
                board[i][j] = (j < idx) ? row[j] : 0;
        }
        return moved;
    }

    // Move tiles right
    public boolean moveRight() {
        boolean moved = false;
        for (int i = 0; i < SIZE; i++) {
            int[] row = new int[SIZE];
            int idx = SIZE - 1;
            int lastMerged = SIZE;
            for (int j = SIZE - 1; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (idx < SIZE - 1 && row[idx + 1] == board[i][j] && lastMerged != idx + 1) {
                        row[idx + 1] *= 2;
                        score += row[idx + 1];
                        lastMerged = idx + 1;
                        moved |= (j != idx + 1);
                    } else {
                        row[idx--] = board[i][j];
                        moved |= (j != idx + 1);
                    }
                }
            }
            for (int j = SIZE - 1; j >= 0; j--)
                board[i][j] = (j > idx) ? row[j] : 0;
        }
        return moved;
    }
}
