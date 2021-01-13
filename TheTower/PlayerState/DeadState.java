package PlayerState;

import PlayerSingleton.PlayerSingleton;
import java.util.Scanner;

/**
 *
 * @author AmirS
 */
public class DeadState implements PlayerState {

    private final PlayerSingleton player;

    /**
     *
     * @param player
     */
    public DeadState(PlayerSingleton player) {
        this.player = player;
    }

    /**
     *
     * @param damage
     */
    @Override 
    public void takeDamage(int damage) {
        int playerLives = player.getLives();
        if (playerLives == 0) {   // if lives == 0
            System.out.println("\tYou have no lives left!");
            System.out.println("\tBlacked out!");
            System.exit(0);     //player dies = stop game.
        }
    }

    /**
     * checks to see if player lives >= 0, if so then player.setState = alive
     */
    @Override
    public void respawn() {
        if (player.getLives() >= 0) {
            player.setLives(player.getLives() - 1);
            System.out.println("--------------------------------------");
            System.out.println(String.format("\tYou have %d lives left!", player.getLives()));
            System.out.println("\tRespawning player in the fight!");
            System.out.println("--------------------------------------");
            player.setState(new AliveState(player));
        } else if (player.getLives() < 0) {
            System.out.println("\tYou have lost all your lives, you blacked out, Game Over...");
            System.exit(0); //if lives < 0 quit game
        }
    }
}
