import state.HappyState;
import state.State;

public class Human {
    private State currentState;

    public Human() {
        this.currentState = new HappyState();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public String getImagePath() {
        return currentState.getImagePath();
    }
}
