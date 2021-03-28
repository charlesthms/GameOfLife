package core;

import gui.Frame;

public class Main {

    public static void main(String[] args) {
        Clock c = new Clock();
        Frame f = new Frame();
        Game g = new Game();

        g.setup();
        f.create();
        c.run();
    }
}
