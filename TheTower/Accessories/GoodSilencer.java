package Accessories;

import Guns.Weapon;

/**
 *
 * @author AmirS
 */
public class GoodSilencer extends AccessoriesDec {

    Weapon weapon;

    /**
     *
     * @param weapon
     */
    public GoodSilencer(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     *
     * @return accessory description
     */
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Good Silencer";
    }

    /**
     *
     * @return accessory weight
     */
    @Override
    public double weight() {
        return 12 + weapon.weight();
    }

    /**
     *
     * @return accessory damage
     */
    @Override
    public int damage() {
        return 12 + weapon.damage();
    }

}
