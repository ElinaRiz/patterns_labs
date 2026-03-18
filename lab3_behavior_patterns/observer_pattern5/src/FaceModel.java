import java.awt.*;
import java.util.Observable;

public class FaceModel extends Observable {
    private boolean leftEyeOpen = false;
    private boolean rightEyeOpen = false;
    private boolean smiling = false;
    private Color noseColor = Color.RED;

    public boolean isLeftEyeOpen() { return leftEyeOpen; }
    public boolean isRightEyeOpen() { return rightEyeOpen; }
    public Color getNoseColor() { return noseColor; }
    public boolean isSmiling() { return smiling; }

    public void toggleEye(boolean isLeft) {
        if (isLeft) {
            leftEyeOpen = !leftEyeOpen;
        } else {
            rightEyeOpen = !rightEyeOpen;
        }
        stateChanged();
    }

    public void changeNoseColor() {
        noseColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
        stateChanged();
    }

    public void makeSmile() {
        if(!smiling) {
            smiling = true;
            stateChanged();
        }
    }

    private void stateChanged() {
        setChanged();
        notifyObservers();
    }
}