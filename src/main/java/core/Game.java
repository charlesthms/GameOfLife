package core;

import gui.Frame;

import java.awt.*;
import java.util.HashMap;

public class Game {

    public static int gen = 0;
    private static HashMap<Point, Cell> hashCells;

    private static long executionTime = 0;

    public Game() {

        hashCells = new HashMap<>();

    }

    public static void createCell(int x, int y) {
        hashCells.put(new Point(x, y), new Cell(x, y, true));
    }

    public static void killCell(int x, int y) {
        hashCells.remove(new Point(x, y));
    }


    public static Cell getCellFromPos(int x, int y) {
        return hashCells.get(new Point(x, y));
    }

    /**
     * Procédure permettant d'actualiser le plateau pour la prochaine génération.
     * <p>
     * Utilise une copie du plateau afin de ne pas s'auto-influencer.
     */
    public static void nextGen(int width, int height) {
        long startTime = System.nanoTime();

        gen++;
        System.out.println("Génération: " + gen);

        HashMap<Point, Cell> copy = new HashMap<>();

        for (int y = 0; y < height; y += Frame.getSIZE()) {
            for (int x = 0; x < width; x += Frame.getSIZE()) {

                int n = countNeighbours(x, y);

                if (n == 3 && getCellFromPos(x, y) == null) {
                    // La cellule à 3 voisins et n'est pas vivante
                    copy.put(new Point(x, y), new Cell(x, y, true));
                } else if (n < 2 || n > 3 && getCellFromPos(x, y) != null) {
                    // Si la cellule existe et à moins et 2 ou plus de 3 voisins
                    copy.remove(new Point(x, y));
                } else {
                    // Sinon, si la cellule est vivante, on la conserve
                    Point currentPoint = new Point(x, y);
                    if (getCellFromPos(x, y) != null) copy.put(currentPoint, new Cell(x, y, true));
                }
            }
        }
        hashCells = new HashMap<>(copy);

        long endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("Temps d'exécution: " + executionTime / 1000000 + "ms");
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

        for (int yoff = y - Frame.getSIZE(); yoff <= y + Frame.getSIZE(); yoff += Frame.getSIZE()) {
            for (int xoff = x - Frame.getSIZE(); xoff <= x + Frame.getSIZE(); xoff += Frame.getSIZE()) {
                try {
                    if (getCellFromPos(xoff, yoff) != null && !(xoff == x && yoff == y)) {
                        count++;
                    }
                } catch (Exception ignored) {

                }
            }
        }
        return count;
    }

    public static HashMap<Point, Cell> getHashCells() {
        return hashCells;
    }

    public static void updateHashCells(HashMap<Point, Cell> hashmap){
        hashCells = new HashMap<>(hashmap);
    }

    public static int getGen(){
        return gen;
    }

    public static long getExecutionTime() {
        return executionTime;
    }

}
