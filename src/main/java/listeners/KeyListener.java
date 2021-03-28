package listeners;

import core.Clock;
import core.Game;
import core.Main;
import gui.Frame;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 82){
            Game.resetBoard();
            Game.nextGen();
        }

        if (e.getKeyCode() == 32){
            // espace
            Clock.inverseClockState();
        }

        if (e.getKeyCode() == 88){
            Frame.close();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
