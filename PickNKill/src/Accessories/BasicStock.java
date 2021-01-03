package Accessories;

import Guns.Weapon;

public class BasicStock extends AccessoryDecorator {

    Weapon weapon;

    public BasicStock(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", basic Stock";
    }

    @Override
    public double weight() {
        return 7 + weapon.weight();
    }

    @Override
    public int damage() {
        return 7 + weapon.damage();
    }

}
