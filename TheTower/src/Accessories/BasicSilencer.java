package Accessories;

import Guns.Weapon;

/**
 *
 * @author AmirS
 */
public class BasicSilencer extends AccessoriesDec {

    Weapon weapon;

    /**
     *
     * @param weapon
     */
    public BasicSilencer(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     *
     * @return accessory description
     */
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Basic Silencer";
    }

    /**
     *
     * @return accessory weight
     */
    @Override
    public double weight() {
        return 7 + weapon.weight();
    }

    /**
     *
     * @return accessory damage
     */
    @Override
    public int damage() {
        return 7 + weapon.damage();
    }

}
