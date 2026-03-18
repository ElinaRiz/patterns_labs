import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Auto {
    private Image image;
    private int x, y;
    private int speed;
    private final int normalSpeed = 9;
    private boolean beforeLine = true;
    private boolean afterLine = false;

    public Auto (int startX, int startY) {
        image = new ImageIcon("auto.png").getImage().getScaledInstance(140, 80, Image.SCALE_SMOOTH);
        this.x = startX;
        this.y = startY;
        this.speed = normalSpeed;
    }

    public void move(boolean shouldStop) {
        int stopX = 220;
        if (beforeLine) {
            x += speed;
            if (x >= stopX - 40) {
                speed = 4;
            }
            if (x >= stopX) {
                beforeLine = false;
            }
        } else if (!afterLine) {
            if (shouldStop) {
                speed = 0;
            } else {
                speed = normalSpeed;
                x += speed;
            }
            if (x > stopX + 30) {
                afterLine = true;
            }
        } else {
            x += speed;
            speed = normalSpeed;
        }
        if (x > 950) {
            reset();
        }
    }

    private void reset() {
        x = -150;
        speed = normalSpeed;
        beforeLine = true;
        afterLine = false;
    }

    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
}
