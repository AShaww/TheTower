package Accessories;

import Guns.Weapon;

public class GreatSight extends AccessoryDecorator {

    Weapon weapon;

    public GreatSight(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Great Sight";
    }

    @Override
    public double weight() {
        return 12 + weapon.weight();
    }

    @Override
    public int damage() {
        return 12 + weapon.damage();
    }
}
