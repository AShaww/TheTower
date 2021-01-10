package Guns;

/**
 * MP5Weapon class extending Weapon
 * @author AmirS
 */
public class MP5Weapon extends Weapon {

    /**
     *  concrete String for MP5Weapon
     */
    public MP5Weapon() {
        description = " Weapon: MP5 has";
    }

    /**
     *
     * @return weapon weight
     */
    @Override
    public double weight() {
        return 12;
    }

    /**
     *
     * @return weapon damage
     */
    @Override
    public int damage() {
        return 13;
    }
}
