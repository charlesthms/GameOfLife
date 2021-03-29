package core;

import gui.Draw;
import gui.Frame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Frame f = new Frame();
        Game g = new Game();
        Clock c = new Clock();

        f.create();
        g.setup();
        c.run();
    }
}
