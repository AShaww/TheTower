package PlayerSingleton;

import PlayerState.*;
import Accessories.*;
import Guns.*;

public final class PlayerSingleton {

    private static PlayerSingleton player;
    private Weapon weapon;

    private final String playerName;
    public static Integer MAX_PLAYER_HEALTH = 200;
    public static Integer DEFAULT_PLAYER_LIVES = 3;

    private Integer health = MAX_PLAYER_HEALTH;
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

        if (player == null) {
            player = new PlayerSingleton(weapon, name);
        }
        return player;
    }

    public void sufferDamage(int takeDamage) {
        playerState.takeDamage(takeDamage);
        if (takeDamage == 0) {
            System.out.println("\tEnemy missed!");
        }
    }

    public int getDamage() {
        return weapon.damage();
    }

    public void respawn() {
        playerState.respawn();
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public void setState(PlayerState playerState) {
        this.playerState = playerState;
    }

    public void chosenWeapon() {
        System.out.println(" Player Info: " + playerName + " " + "has: " + player.getHealth() + " health and "
                + lives + " lives" + " : " + weapon.getDescription() + ":" + " base damage: " + weapon.damage());
        System.out.println(" ################################################################################### ");
        System.out.println();

    }

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
