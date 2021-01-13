package MovementStrategy;

/**
 *
 * @author AmirS
 */
public class MoveForward implements MovementStrategy {

    /**
     *
     * @return string based on type of movement
     */
    @Override
    public String doMovement() {
        return "You chose to go Forward";
    }
}
