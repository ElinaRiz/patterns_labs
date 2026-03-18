package gui;

import ball.AbstractBall;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AnimationPanel extends JPanel {
    private List<AbstractBall> shapes = new ArrayList<>();

    public AnimationPanel() {
        setBackground(Color.BLACK);
    }

    public void addShape(AbstractBall shape) {
        shapes.add(shape);
        new Thread(shape).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (AbstractBall shape : shapes) {
            shape.draw(g);
        }
    }
}