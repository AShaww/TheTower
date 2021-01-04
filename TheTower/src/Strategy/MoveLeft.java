package Strategy;

public class MoveLeft implements MovementStrategy {

    @Override
    public String doMovement() {
        return "You chose to go Left";
    }
}
