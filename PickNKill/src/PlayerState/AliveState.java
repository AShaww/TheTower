package PlayerState;

import PlayerSingleton.PlayerSingleton;
import java.util.HashSet;
import java.util.Set;

public class AliveState implements PlayerState {

    private final PlayerSingleton player;

    public AliveState(PlayerSingleton player) {
        this.player = player;
        this.player.setHealth(PlayerSingleton.MAX_PLAYER_HEALTH);
    }

    @Override
    public void takeDamage(int playerDamage) {
        System.out.println(String.format("\tEnemy hit you for %d damage!", playerDamage));
        player.setHealth(player.getHealth() - playerDamage);

        if (player.getHealth() <= 0) {
            player.setLives(player.getLives() - 1);
        
            player.setState(new DeadState(player));
        }
    }

    @Override
    public void respawn() {   
        System.out.println("\tNothing to do, player is alive!");
    }
}
