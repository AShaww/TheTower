
package PlayerState;

/**
 * Interface for state pattern, having alive and dead state implement from this interface.
 * @author AmirS
 */
public interface PlayerState {
  void respawn();
  void sufferDamage(int damage);
}
