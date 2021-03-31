package gui;

import core.Game;

import javax.swing.*;
import java.awt.*;

public class ControlPanel {

    Frame frame;
    Timer timer;
    JLabel generation, speed, time, executionTime;
    JSlider slider, source;
    JButton start, reset;

    int delay;

    public JButton getStart() {
        return start;
    }

    public ControlPanel(Frame frame, Timer timer){

        this.frame = frame;
        this.timer = timer;

        // Texte de génération
        generation = new JLabel("GENERATION: " + Game.getGen());
        generation.setForeground(new Color(255, 255, 255));

        // Texte de vitesse
        speed = new JLabel("VITESSE: ");
        speed.setForeground(new Color(255, 255, 255));

        // Texte de temps de calcul
        time = new JLabel("TEMPS DE CALCUL: ");
        time.setForeground(new Color(255, 255, 255));

        // Vitesse d'exécution
        executionTime = new JLabel(Game.getExecutionTime() / 1000000 + "ms");
        executionTime.setForeground(new Color(255, 255, 255));

        // Slider de sélection de vitesse
        slider = new JSlider();
        slider.setOpaque(false);
        slider.setFocusable(false);
        slider.setPaintTicks(true);
        slider.setVisible(true);
        slider.addChangeListener(e -> {
            source = (JSlider) e.getSource();
            slider.setValue(source.getValue());
            frame.repaint();
            double a1 = (5000.0000 / (Math.pow(25/500.0, 1/40.0)));
            delay = (int)(a1 * (Math.pow(25/500.0, slider.getValue() / 40.0)));
            timer.setDelay(delay);
        });

        // Bouton de start
        start = new JButton("Start");
        start.setFocusable(false);
        start.setMargin(new Insets(0,0,0,0));
        start.addActionListener(frame);
        start.setVisible(true);

        // Bouton de reset
        reset = new JButton("Reset");
        reset.setFocusable(false);
        reset.setMargin(new Insets(0,0,0,0));
        reset.addActionListener(frame);
        reset.setVisible(true);

    }

    public void addControls(){
        frame.add(slider);
        frame.add(speed);
        frame.add(generation);
        frame.add(time);
        frame.add(executionTime);
        frame.add(start);
        frame.add(reset);
    }

    public void paintControls(int height){

        slider.setBounds(10, height - 50, 100, 70);

        start.setBounds(130, height - 33, 50, 20);
        reset.setBounds(190, height - 33, 50, 20);

        generation.setBounds(15, height - 100, 200, 70);
        generation.setText("GENERATION: " + Game.getGen());

        speed.setBounds(20, height - 80, 200, 70);
        speed.setText("VITESSE: " + slider.getValue());

        time.setBounds(130, height - 100, 200, 70);
        time.setText("TEMPS DE CALCUL: ");
        executionTime.setBounds(130, height - 80, 200, 70);
        executionTime.setText(Game.getExecutionTime() / 1000000 + "ms");

    }

}
