package Guns;

/**
 *
 * @author AmirS
 */
public class ShotgunWeapon extends Weapon {

    /**
     *  concrete String for weapon
     */
    public ShotgunWeapon() {
        description = " Weapon: Shotgun has";
    }

    /**
     *
     * @return weapon weight
     */
    @Override
    public double weight() {
        return 20;
    }

    /**
     *
     * @return weapon damage
     */
    @Override
    public int damage() {
        return 35;
    }
}
