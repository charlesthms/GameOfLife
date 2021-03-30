package core;

import gui.Draw;

import java.awt.*;
import java.util.Arrays;

public class Game {

    public static boolean[][] board = new boolean[1][1];
    public static int gen = 0;

    public void setup() {
        for (boolean[] row : board) {
            Arrays.fill(row, false);
        }
    }

    /**
     * Procédure permettant d'actualiser le plateau pour la prochaine génération.
     * <p>
     * Utilise une copie du plateau afin de ne pas s'auto-influencer.
     */
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


    /**
     * Fonction permettant d'initialiser un nouveau plateau.
     *
     * @return Nouveau plateau rempli de false.
     */
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
        gen = 0;
        board = initNewBoard();
    }

    /**
     * Fonction permettant de compter le nombre de voisin(s) d'une cellule
     *
     * @param x Position x
     * @param y Position y
     * @return Nombre de voisin(s) de la cellule à la position (x, y)
     */
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
