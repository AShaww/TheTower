package Guns;

/**
 *
 * @author AmirS
 */
public class RifleWeapon extends Weapon {

    /**
     * concrete String for weapon
     */
    public RifleWeapon() {
        description = " Weapon: Rifle has";
    }

    /**
     *
     * @return weapon weight
     */
    @Override
    public double weight() {
        return 25;
    }

    /**
     *
     * @return weapon damage
     */
    @Override
    public int damage() {
        return 53;
    }

}
