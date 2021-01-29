package NotInUseStrategy;

/**
 *
 * @author AmirS
 */
public class MoveBackward implements MovementStrategy {

    /**
     *
     * @return string based on type of movement
     */
    @Override
    public String doMovement() {
        return "You chose to go Back";
    }
}