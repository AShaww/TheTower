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
        System.out.println("\tCannot do anything player is dead!");  
    }

    @Override
    public void respawn() {

        if (player.getLives() > 0) {
            int playerLives = player.getLives();
            System.out.println(String.format("\tYou have %d lives left!", playerLives));
            System.out.println("\tRespawning player in the fight!");
            System.out.println();
            player.setState(new AliveState(player));
        } else if(player.getLives() <= 0) {
            System.out.println("\tYou Blackout, Game Over...");
            System.exit(0);
        } 
    }
}