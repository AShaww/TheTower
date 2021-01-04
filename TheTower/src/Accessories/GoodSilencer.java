package Accessories;

import Guns.Weapon;

public class GoodSilencer extends AccessoryDecorator {

    Weapon weapon;

    public GoodSilencer(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Good Silencer";
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
