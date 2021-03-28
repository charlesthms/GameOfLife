package core;

import gui.Draw;

import java.util.Arrays;

public class Game {

    public static boolean[][] board = new boolean[Draw.cellCount][Draw.cellCount];
    public static int gen = 0;

    public void setup() {
        for (boolean[] row : board) {
            Arrays.fill(row, false);
        }
    }

    public static void nextGen() {
        gen++;
        System.out.println("Génération: " + gen);

        boolean[][] updatedBoard = initNewBoard();

        for (int y = 0; y < Draw.cellCount; y++) {
            for (int x = 0; x < Draw.cellCount; x++) {

                int n = countNeighbours(x, y);

                if (n == 3 && !board[y][x]) {
                    updatedBoard[y][x] = true;
                } else if (n < 2 || n > 3) {
                    updatedBoard[y][x] = false;
                } else {
                    updatedBoard[y][x] = board[y][x];
                }
            }
        }
        board = updatedBoard;
    }

    private static boolean[][] initNewBoard() {
        boolean[][] newBoard = new boolean[Draw.cellCount][Draw.cellCount];

        for (int i = 0; i < Draw.cellCount; i++) {
            for (int j = 0; j < Draw.cellCount; j++) {
                newBoard[i][j] = false;
            }
        }
        return newBoard;
    }

    public static void resetBoard() {
        board = initNewBoard();
    }

    public static int countNeighbours(int x, int y) {
        int count = 0;

        for (int yoff = y - 1; yoff <= y + 1; yoff++) {
            for (int xoff = x - 1; xoff <= x + 1; xoff++) {
                try {
                    if (board[yoff][xoff] && !(xoff == x && yoff == y)) {
                        count++;
                    }
                } catch (Exception ignored) {

                }
            }
        }
        return count;
    }

}
