package gui;

import core.Game;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    public static int cellWidth = 20;
    public final static int cellCount = 800 / cellWidth;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        drawBoardState(g);
        drawGrid(g);
        repaint();
    }

    public static void drawBoardState(Graphics g){
        for (int row=0; row<cellCount; row++){
            for (int col=0; col<cellCount; col++){
                if (Game.board[row][col]){
                    g.setColor(new Color(0, 0, 0));
                } else {
                    g.setColor(new Color(255, 255, 255));
                }
                g.fillRect(cellWidth * col, cellWidth * row, cellWidth, cellWidth);
            }
        }
    }

    public static void drawGrid(Graphics g){
        g.setColor(new Color(55, 55, 55));
        for (int i = 0; i <= 800; i += cellWidth) {
            g.drawLine(i, 0, i, 800);
        }
        for (int i = 0; i <= 800; i += cellWidth) {
            g.drawLine(0, i, 800, i);
        }
    }

}
