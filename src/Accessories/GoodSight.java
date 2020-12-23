package Accessories;

import Guns.Weapon;

public class GoodSight extends AccessoryDecorator {

    Weapon weapon;

    public GoodSight(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Good Sight";
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
