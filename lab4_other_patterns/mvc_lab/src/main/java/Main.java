import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            View view = new View(model);
            Controller controller = new Controller(model, view);
            controller.start();
        });
    }
}