package NotInUseStrategy;

/**
 *
 * @author AmirS
 */
public class MoveRight implements MovementStrategy {

    /**
     *
     * @return string based on type of movement
     */
    @Override
    public String doMovement() {
        return "You chose to go Right";
    }
}
