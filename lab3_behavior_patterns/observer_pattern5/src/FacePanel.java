import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;

public class FacePanel extends JPanel implements Observer {
    private FaceModel model;
    private BufferedImage faceImg, leftEyeImg, rightEyeImg, smileImg;

    private Rectangle leftEyeArea = new Rectangle(104, 175, 72, 48);
    private Rectangle rightEyeArea = new Rectangle(175, 175, 77, 50);
    private Rectangle noseArea = new Rectangle(166, 204, 20, 20);
    private Rectangle mouthArea = new Rectangle(122, 228, 110, 54);

    public FacePanel(FaceModel model) {
        this.model = model;
        this.model.addObserver(this);

        try {
            faceImg = ImageIO.read(new File("src/images/default_face.jpg"));
            leftEyeImg = ImageIO.read(new File("src/images/left_eye.jpg"));
            rightEyeImg = ImageIO.read(new File("src/images/right_eye.jpg"));
            smileImg = ImageIO.read(new File("src/images/smile.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (noseArea.contains(p)) {
                    model.changeNoseColor();
                } else if (leftEyeArea.contains(p)) {
                    model.toggleEye(true);
                } else if (rightEyeArea.contains(p)) {
                    model.toggleEye(false);
                } else if (mouthArea.contains(p)) {
                    model.makeSmile();

                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(faceImg, 0, 0, this);

        if (model.isLeftEyeOpen()) {
            g.drawImage(leftEyeImg, leftEyeArea.x, leftEyeArea.y, leftEyeArea.width, leftEyeArea.height, this);
        }
        if (model.isRightEyeOpen()) {
            g.drawImage(rightEyeImg, rightEyeArea.x, rightEyeArea.y, rightEyeArea.width, rightEyeArea.height, this);
        }
        if (model.isSmiling()) {
            g.drawImage(smileImg, mouthArea.x, mouthArea.y, mouthArea.width, mouthArea.height, this);
        }

        g.setColor(model.getNoseColor());
        g.fillOval(noseArea.x, noseArea.y, noseArea.width, noseArea.height);
    }

    public void update(Observable o, Object arg) {
        repaint();
    }
}