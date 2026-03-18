package ball;

import gui.AnimationPanel;
import java.awt.*;
import java.util.Random;

public abstract class AbstractBall implements Runnable {
    private AnimationPanel panel;
    private int x, y, stepX, stepY;
    private int size = 30;

    public AbstractBall(AnimationPanel panel) {
        this.panel = panel;
        x = panel.getWidth() - size;
        y = panel.getHeight() - size;
        stepX = - 1 - (int)(Math.random() * 10);
        stepY = - 1 - (int)(Math.random() * 10);
    }

    public void run() {
        while (true) {
            x += stepX;
            y += stepY;

            if (x < 0 || x > panel.getWidth() - size) {
                stepX = -stepX;
            }
            if (y < 0 || y > panel.getHeight() - size) {
                stepY = -stepY;
            }

            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public abstract void draw(Graphics g);
}