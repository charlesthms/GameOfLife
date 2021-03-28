package gui;

import listeners.ClickListener;
import listeners.KeyListener;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class Frame {

    public static JFrame frame;
    public static Draw d;
    public static final int SIZE = 800;

    public void create(){

        frame = new JFrame("The Game Of Life");
        frame.setSize(817, 840); //817 x 840
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        d = new Draw();
        d.setBounds(0, 0, 800, 800);
        d.setVisible(true);

        d.addMouseListener(new ClickListener());
        frame.addKeyListener(new KeyListener());
        frame.add(d);

        frame.setVisible(true);
    }

    public static void close(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

}
