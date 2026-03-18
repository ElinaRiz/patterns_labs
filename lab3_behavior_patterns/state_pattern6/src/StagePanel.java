import state.*;

import javax.swing.*;
import java.awt.*;

public class StagePanel extends JPanel {
    private Human human;
    private JLabel imageLabel;

    public StagePanel() {
        human = new Human();
        imageLabel = new JLabel();
        JButton semesterBtn = new JButton("Семестр");
        JButton vacationBtn = new JButton("Каникулы");
        JButton examBtn = new JButton("Сессия");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(semesterBtn);
        buttonPanel.add(vacationBtn);
        buttonPanel.add(examBtn);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        updateImage();

        semesterBtn.addActionListener(e -> {
            human.setState(new SleepState());
            updateImage();
        });

        vacationBtn.addActionListener(e -> {
            human.setState(new HappyState());
            updateImage();
        });

        examBtn.addActionListener(e -> {
            human.setState(new StressState());
            updateImage();
        });
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(human.getImagePath());
        Image scaledImage = icon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
    }
}