package gui;

import core.Cell;
import core.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;


/**
 * Classe principale d'affichage. Permet de gérer la fenêtre de jeu ainsi que les listeners
 */
public class Frame extends JPanel implements ActionListener, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    private final JFrame frame;
    private static int SIZE = 25;
    private int delay = 100;
    private Timer timer = new Timer(delay, this);

    ControlPanel cp;

    public static void main(String[] args) {
        new Game();
        new Frame();
    }

    public Frame() {

        cp = new ControlPanel(this, timer);

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

        // Ajout du controlPanel
        cp.addControls();

        this.setLayout(null);
        frame.setLayout(null);

        frame.revalidate();
        frame.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessin des cellules vivantes
        for (Point p : Game.getHashCells().keySet()) {
            g.fillRect(p.x, p.y, SIZE, SIZE);
        }

        // Dessin de la grille
        g.setColor(Color.lightGray);
        for (int j = 0; j < this.getHeight(); j += SIZE) {
            for (int i = 0; i < this.getWidth(); i += SIZE) {
                g.drawRect(i, j, SIZE, SIZE);
            }
        }

        // Dessin du controlPanel
        g.setColor(new Color(0, 0, 0, 119));
        g.fillRect(10, getHeight() - 80, 250, 70);
        cp.paintControls(getHeight());

    }

    public void cellsManagement(MouseEvent e) {
        // Clic gauche de la souris
        if (SwingUtilities.isLeftMouseButton(e)) {

            int xBorder = e.getX() - (e.getX() % SIZE);
            int yBorder = e.getY() - (e.getY() % SIZE);

            // Création d'une cellule vivante
            Game.createCell(xBorder, yBorder);
        }
        // Clic droit de la souris
        else if (SwingUtilities.isRightMouseButton(e)) {
            int mouseBoxX = e.getX() - (e.getX() % SIZE);
            int mouseBoxY = e.getY() - (e.getY() % SIZE);

            // Kill d'une cellule vivante
            Game.killCell(mouseBoxX, mouseBoxY);

        }
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualisation pour la prochaine génération
        if (e.getActionCommand() != null) {
            // Action d'un des boutons
            if (e.getActionCommand().equalsIgnoreCase("start") || e.getActionCommand().equalsIgnoreCase("pause")) {
                buttonManage();
            } else if (e.getActionCommand().equalsIgnoreCase("reset")) {
                resetFrame();
            }

        } else {

            Game.nextGen(getWidth(), getHeight());
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        char key = e.getKeyChar();

        if (key == 'r') {
            resetFrame();
        } else if (key == 'x') {
            // Fermeture de la fenêtre
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        } else if (key == KeyEvent.VK_SPACE) {
            buttonManage();
        } else if (key == 't') {
            // Changement manuel de la vitesse
            timer.stop();
            delay = Integer.parseInt(JOptionPane.showInputDialog("Nouvelle vitesse (en ms) : "));
            timer.setDelay(delay);
            timer.restart();
        }
    }

    private void buttonManage() {
        if (cp.getStart().getText().equalsIgnoreCase("start")) {
            System.out.println("GENERATION STARTED");
            timer.start();
            cp.start.setText("Pause");
        } else {
            System.out.println("GENERATION PAUSED");
            timer.stop();
            cp.start.setText("Start");
        }
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
        int scroll = 1;

        // Changement de la taille de la grille par rapport au zoom
        if (rotation == -1 && SIZE + scroll < 200) {
            SIZE += scroll;
        } else if (rotation == 1 && SIZE - scroll > 2) {
            SIZE += -scroll;
        }

        double ratio = SIZE / prevSize;

        // Adaptation de la taille des cellules en fonction du zoom actif représenté par le ratio
        HashMap<Point, Cell> newHashCells = new HashMap<>();

        for (Point p : Game.getHashCells().keySet()) {
            int newX = (int) Math.round((p.x * ratio));
            int newY = (int) Math.round((p.y * ratio));

            newHashCells.put(new Point(newX, newY), new Cell(newX, newY, false));
        }

        Game.updateHashCells(newHashCells);
        repaint();
    }

    public void resetFrame() {
        timer.stop();
        Game.gen = 0;
        Game.getHashCells().clear();
        repaint();
        System.out.println("FRAME CLEARED");
    }

    public static int getSIZE() {
        return SIZE;
    }

    public Timer getTimer() {
        return timer;
    }
}
