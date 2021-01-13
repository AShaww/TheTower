package Accessories;

import Guns.Weapon;

/**
 *
 * @author AmirS
 */
public class GoodStock extends AccessoriesDec {

    Weapon weapon;

    /**
     *
     * @param weapon
     */
    public GoodStock(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     *
     * @return accessory description
     */
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Good Stock";
    }

    /**
     *
     * @return
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
