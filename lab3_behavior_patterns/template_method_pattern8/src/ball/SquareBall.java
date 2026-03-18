package ball;

import gui.AnimationPanel;
import java.awt.*;

public class SquareBall extends AbstractBall {
    public SquareBall(AnimationPanel panel) {
        super(panel);
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), getSize(), getSize());
    }
}