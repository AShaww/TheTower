package PlayerState;

import PlayerSingleton.PlayerSingleton;
import java.util.Scanner;

/**
 *
 * @author AmirS
 */
public class DeadState implements PlayerState {

    private final PlayerSingleton player;
    Scanner scanner = new Scanner(System.in);

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
        if (playerLives == 0) {  //added while loop to help reader read the you died Window. Instead of theh console closing instantly.
            System.out.println("\tYou have no lives left!");
            System.out.println("\tBlacked out!" + " You have Died");
            System.out.println("Close console? ");  //adding this does not immediately close the console while running game using batch.
            System.out.println(" '1' Yes");
            int answer = scanner.nextInt();
            while (answer != 1) {
                System.out.println("Close console? ");
                System.out.println(" 1. Yes");
                answer = scanner.nextInt();
                if (answer == 1) {
                    System.exit(0);
                    break;  //to ensure that the game stops after 1 has been entered.
                }
            }
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
