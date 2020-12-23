package Accessories;

import Guns.Weapon;

public class GreatStock extends AccessoryDecorator {

    Weapon weapon;

    public GreatStock(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Great Stock";
    }

    @Override
    public double weight() {
        return 15 + weapon.damage();
    }

    @Override
    public int damage() {
        return 15 + weapon.damage();
    }

}
