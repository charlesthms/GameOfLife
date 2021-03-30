package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    static JFrame frame;
    static int SIZE = 25;
    char currentKey = (char) 0;

    Timer timer = new Timer(100, this);

    public static void main(String[] args) {
        new Frame();
    }

    public Frame() {

        // Ajout des listeners
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        addKeyListener(this);
        setBackground(Color.WHITE);

        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Configuration de la fenêtre
        frame = new JFrame();
        frame.setContentPane(this);
        frame.setTitle("The Game of Life");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Charles\\Desktop\\favicon_package_v0.16\\android-chrome-512x512.png"));
        frame.getContentPane().setPreferredSize(new Dimension(700, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessin de la grille
        g.setColor(Color.lightGray);
        for (int j = 0; j < this.getHeight(); j += SIZE) {
            for (int i = 0; i < this.getWidth(); i += SIZE) {
                g.drawRect(i, j, SIZE, SIZE);
            }
        }
    }

    public void cellsManagement(MouseEvent e) {
        // Clic gauche de la souris
        if (SwingUtilities.isLeftMouseButton(e)) {

            int xBorder = e.getX() - (e.getX() % SIZE);
            int yBorder = e.getY() - (e.getY() % SIZE);

            // Création d'une cellule vivante
            System.out.println(xBorder + ", " + yBorder);

        }
        // Clic droit de la souris
        else if (SwingUtilities.isRightMouseButton(e)) {
            int mouseBoxX = e.getX() - (e.getX() % SIZE);
            int mouseBoxY = e.getY() - (e.getY() % SIZE);

            // Création d'une cellule morte

        }
        // repaint();
    }

    public static void close() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        cellsManagement(e);
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

    @Override
    public void mouseDragged(MouseEvent e) {
        cellsManagement(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int rotation = e.getWheelRotation();
        double prevSize = SIZE;
        int scroll = 3;

        // Changes size of grid based on scroll
        if (rotation == -1 && SIZE + scroll < 200) {
            SIZE += scroll;
        } else if (rotation == 1 && SIZE - scroll > 2) {
            SIZE += -scroll;
        }
        repaint();
    }
}
