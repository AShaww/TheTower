package NotInUseStrategy;

/**
 *
 * @author AmirS
 */
public class MoveContext {

    private MovementStrategy movementStrat;
    private String playerMovement;

    /**
     *
     * @param movement
     */
    public void setMovement(MovementStrategy movement) {
        this.movementStrat = movement;
    }

    /**
     * method for calling individual movement method
     */
    public void movementStrategy() {
        System.out.println("Player has chosen" + this.playerMovement);
    }

}
