package PlayerState;

import PlayerSingleton.PlayerSingleton;
import java.util.Scanner;

public class DeadState implements PlayerState {

    private final PlayerSingleton player;

    public DeadState(PlayerSingleton player) {
        this.player = player;
    }

    @Override
    public void takeDamage(int damage) {
        int playerLives = player.getLives();
        if(playerLives > 0){
            //System.out.println("\tYou died, respwaning you back in the fight...");
        }
        if(playerLives == 0){
            System.out.println("\tYou have no lives left!");
            System.out.println("\tBlacked out!");
            System.exit(0);
        }
    }

    @Override
    public void respawn() {
        if (player.getLives() >= 0) {
            int playerLives = player.getLives();
            System.out.println(String.format("\tYou have %d lives left!", playerLives));
            System.out.println("\tRespawning player in the fight!");
            System.out.println();
            player.setState(new AliveState(player));
        } else if(player.getLives() < 0) {
            System.out.println("\tYou have lost all your lives, you blacked out, Game Over...");
            System.exit(0);
        } 
    }
}
