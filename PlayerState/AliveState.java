package PlayerState;

import PlayerSingleton.PlayerSingleton;
/**
 * 
 * @author AmirS
 */
public class AliveState implements PlayerState {

    private final PlayerSingleton player;

    /**
     *
     * @param player
     */
    public AliveState(PlayerSingleton player) {
        this.player = player;
        this.player.setHealth(player.getHealth());
    }

    /**
     *  
     * @param enemyDamage
     */
    @Override
    public void sufferDamage(int enemyDamage) {  
        player.setHealth(player.getHealth() - enemyDamage);    //sets health based on getHealth minus enemyDamage.
        
        if (player.getHealth() <= 0) {    
            player.setState(new DeadState(player)); //if playerHealth is below 0 or 0 then setState(new DeadState) which checks lives and health.
        }
    }

    /**
     * Player is still in Alive State, Player is alive.
     */
    @Override
    public void respawn() {   
        System.out.println("\tNothing to do, player is alive!");
    }
}
