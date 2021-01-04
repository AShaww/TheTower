package Accessories;

import Guns.Weapon;

public class GoodStock extends AccessoryDecorator {

    Weapon weapon;

    public GoodStock(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Good Stock";
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
