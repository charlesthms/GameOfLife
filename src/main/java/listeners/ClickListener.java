package listeners;

import core.Game;
import gui.Draw;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener extends JPanel implements MouseListener {

    public static boolean between(int i, int minValueInclusive, int maxValue) {
        return i >= minValueInclusive && i < maxValue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isLeftMouseButton(e)){
            for (int row = 0; row < Draw.cellCount; row++) {
                for (int col = 0; col < Draw.cellCount; col++) {
                    if (between(e.getX(), col * Draw.cellWidth, col * Draw.cellWidth + Draw.cellWidth) &&
                            between(e.getY(), row * Draw.cellWidth, row * Draw.cellWidth + Draw.cellWidth)) {
                        System.out.println("Click sur la case en : " + col + ", " + row);

                        Game.board[row][col] = !Game.board[row][col];
                        repaint();
                    }
                }
            }
        } else {
            Game.nextGen();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
