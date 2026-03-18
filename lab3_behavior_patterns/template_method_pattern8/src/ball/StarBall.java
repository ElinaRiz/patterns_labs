package ball;

import gui.AnimationPanel;
import java.awt.*;

public class StarBall extends AbstractBall {
    public StarBall(AnimationPanel panel) {
        super(panel);
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        int x = getX();
        int y = getY();
        int size = getSize();
//        int[] xs = {x+15, x+20, x+30, x+22, x+25, x+15, x+5, x+8, x, x+10};
//        int[] ys = {y, y+10, y+10, y+18, y+30, y+24, y+30, y+18, y+10, y+10};

        int[] xs = {x+size/2, x+2*size/3, x+size, x+11*size/15, x+5*size/6, x+size/2, x+size/6, x+4*size/15, x, x+size/3};
        int[] ys = {y, y+size/3, y+size/3, y+3*size/5, y+size, y+4*size/5, y+size, y+3*size/5, y+size/3, y+size/3};
        g.fillPolygon(xs, ys, xs.length);
    }
}