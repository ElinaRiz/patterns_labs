package gui;

import ball.*;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Паттерн Template Method. Мяч");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        AnimationPanel animationPanel = new AnimationPanel();
        add(animationPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("Пуск");
        JButton closeButton = new JButton("Закрыть");

        JRadioButton circleButton = new JRadioButton("Круг", true);
        JRadioButton squareButton = new JRadioButton("Квадрат");
        JRadioButton starButton = new JRadioButton("Звезда");

        startButton.addActionListener(e -> {
            if (circleButton.isSelected())
                animationPanel.addShape(new CircleBall(animationPanel));
            if (squareButton.isSelected())
                animationPanel.addShape(new SquareBall(animationPanel));
            if (starButton.isSelected())
                animationPanel.addShape(new StarBall(animationPanel));
        });

        closeButton.addActionListener(e -> System.exit(0));

        ButtonGroup group = new ButtonGroup();
        group.add(circleButton);
        group.add(squareButton);
        group.add(starButton);

        JPanel radioPanel = new JPanel();
        radioPanel.add(circleButton);
        radioPanel.add(squareButton);
        radioPanel.add(starButton);

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(radioPanel);
        controlPanel.add(closeButton);
        add(controlPanel, BorderLayout.SOUTH);
    }
}
