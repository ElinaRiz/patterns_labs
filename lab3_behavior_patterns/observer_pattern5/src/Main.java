import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FaceModel model = new FaceModel();
            JFrame frame = new JFrame("Паттерн Observer. Клоун");
            frame.setSize(380, 402);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new FacePanel(model));
            frame.setVisible(true);
        });
    }
}