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
        if (player.getLives() >= 0) {
            System.out.println("\tRespawning player to checkpoint");
            player.setState(new AliveState(player));
        } else {
            System.out.println("\tGame Over!");    
        }
    }
}
