package listeners;

import core.Clock;
import core.Game;
import gui.Frame;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 82){
            // r
            Game.resetBoard();

        }

        if (e.getKeyCode() == 32){
            // espace
            System.out.println("espace");
            Clock.generate = !Clock.generate;
        }

        if (e.getKeyCode() == 88){
            // x
            Frame.close();
        }

        if (e.getKeyCode() == 84){
            // t
            try {
                Clock.generate = false;
                Clock.speed = Integer.parseInt(JOptionPane.showInputDialog("Nouvelle vitesse (en ms) : "));
                Clock.generate = true;
            } catch (Exception ignored){

            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
