package PlayerSingleton;

import PlayerState.*;
import Accessories.*;
import Guns.*;

/**
 *
 * @author AmirS
 */
public final class PlayerSingleton{

        
    private static PlayerSingleton player;
    private Weapon weapon;

    private final String playerName;
    /**
     * The value of MAX_PLAYER_HEALTH {@value #MAX_PLAYER_HEALTH} 
     */
    private static final int MAX_PLAYER_HEALTH = 200;
    
    /**
     * The value of DEFAULT_PLAYER_LIVES {@value #DEFAULT_PLAYER_LIVES}
     */
    private static final int DEFAULT_PLAYER_LIVES = 3;

    private int health = MAX_PLAYER_HEALTH;
    private int lives = DEFAULT_PLAYER_LIVES;
    private PlayerState playerState;

    private PlayerSingleton(Weapon weapon, String pName) {
        this.weapon = weapon;
        this.playerName = pName;
        setState(new AliveState(this));
    }

    /**
     *
     * @param choice String choice of weapon
     * @param name String player name
     * @return PlayerSingleton the player instance
     */
    public static PlayerSingleton getInstance(String choice, String name) {

        Weapon weapon = PlayerSingleton.chooseWeapon(choice);
        weapon.getDescription();

        if (player == null) {               // if player is null
            player = new PlayerSingleton(weapon, name);  // create new object PlayerSingleton(weapon, name)
        }
        return player;
    }

    /**
     * 
     * @param takeDamage
     */
    public void sufferDamage(int takeDamage) {
        playerState.takeDamage(takeDamage);
        if (takeDamage == 0) {
            System.out.println("\tEnemy missed!");
        }
    }

    /**
     *
     * @return playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *
     * @return weapon.damage
     */
    public int getDamage() {
        return weapon.damage();
    }

    /**
     * Checks playerState respawn method for current lives. 
     */
    public void respawn() {
        playerState.respawn();
    }

    /**
     *
     * @return lives
     */
    public int getLives() {
        return lives;
    }

    /**
     *
     * @param lives
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *
     * @param playerState
     */
    public void setState(PlayerState playerState) {
        this.playerState = playerState;
    }

    /**
     *  
     */
    public void chosenWeapon() {
        System.out.println(weapon.getDescription() + ": base damage: " + weapon.damage());
    }

    /**
     *
     * @param choice
     * @return case
     */
    public static Weapon chooseWeapon(String choice) {
        switch (choice) {
            case "M":
                System.out.println(" You have chosen MP5!");
                return new MP5Weapon();
            case "R":
                System.out.println(" You have chosen Rifle!");
                return new RifleWeapon();
            case "S":
                System.out.println(" You have chosen Shotgun!");
                return new ShotgunWeapon();
            default:
                System.out.println(" No gun by that name found!");
                return null;
        }
    }

    /**
     *
     * @param attachment
     */
    public void addBasicAttachment(String attachment) {
        switch (attachment) {
            case "Sight":
                weapon = new BasicSight(weapon);
                break;
            case "Silencer":
                weapon = new BasicSilencer(weapon);
                break;
            case "Stock":
                weapon = new BasicStock(weapon);
                break;
            default:
                System.out.println("\tNo Attachment found!");
        }
    }

    /**
     * 
     * @param attachment
     */ 
    public void addGoodAttachment(String attachment) {
        switch (attachment) {
            case "Sight":
                weapon = new GoodSight(weapon);
                break;
            case "Silencer":
                weapon = new GoodSilencer(weapon);
                break;
            case "Stock":
                weapon = new GoodStock(weapon);
                break;
            default:
                System.out.println("\tNo Attachment found!");
        }
    }
}
