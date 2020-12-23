package Accessories;

import Guns.Weapon;

/**
 *
 * @author AmirS
 */
public class GreatSilencer extends AccessoryDecorator {

    Weapon weapon;

    public GreatSilencer(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Get the description of the silencer accessory
     * @return String the name of the accessory.
     */
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Great Silencer";
    }

    @Override
    public double weight() {
        return 15 + weapon.weight();
    }

    @Override
    public int damage() {
        return 15 + weapon.damage();
    }
}
