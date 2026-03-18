import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficFacade extends JPanel implements ActionListener {
    private Image background;
    private TrafficLight trafficLight;
    private Auto auto;
    private Timer timer;

    public TrafficFacade(int width, int height) {
        background = new ImageIcon("road.jpg").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        trafficLight = new TrafficLight();
        auto = new Auto(-150, 270);
        timer = new Timer(100, this);
        timer.start();
        new Timer(6000, e -> trafficLight.nextLight()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, this);
        auto.draw(g);
        g.drawImage(trafficLight.getCurrentLight(), 650, 280, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        auto.move(trafficLight.shouldStop());
        repaint();
    }
}