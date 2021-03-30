package gui;

import javax.swing.*;

public class ControlPanel {

    private Frame frame;
    private JLabel generation;

    public ControlPanel(Frame frame){
        this.frame = frame;

        generation = new JLabel("Génération: ");
        generation.setName("generation");
        generation.setFont(style.bigText);
        generation.setForeground(style.darkText);
        generation.setVisible(true);
    }

}
