package Strategy;

public class MoveContext {

    private MovementStrategy movementStrat;
    private String playerMovement;

    public void setMovement(MovementStrategy movement) {
        this.movementStrat = movement;
    }

    public void movementStrategy() {
        System.out.println("Player has chosen" + this.playerMovement);
    }

}
