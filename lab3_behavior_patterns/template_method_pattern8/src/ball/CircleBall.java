package ball;

import gui.AnimationPanel;
import java.awt.*;

public class CircleBall extends AbstractBall {
    public CircleBall(AnimationPanel panel) {
        super(panel);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(getX(), getY(), getSize(), getSize());
    }
}