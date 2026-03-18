import javax.swing.ImageIcon;
import java.awt.Image;

public class TrafficLight {
    private Image redLight, yellowLight, greenLight;
    private int light = 2;

    public TrafficLight() {
        redLight = new ImageIcon("traffic-light-red.png").getImage().getScaledInstance(35, 95, Image.SCALE_SMOOTH);
        yellowLight = new ImageIcon("traffic-light-yellow.png").getImage().getScaledInstance(35, 95, Image.SCALE_SMOOTH);
        greenLight = new ImageIcon("traffic-light-green.png").getImage().getScaledInstance(35, 95, Image.SCALE_SMOOTH);
    }

    public void nextLight() {
        light = (light + 1) % 4;
    }

    public Image getCurrentLight() {
        return switch (light) {
            case 0 -> redLight;
            case 2 -> greenLight;
            default -> yellowLight;
        };
    }

    public boolean shouldStop() {
        return light == 0 || light == 1 || light == 3;
    }
}