package Accessories;

import Guns.Weapon;

public class BasicSilencer extends AccessoryDecorator {

    Weapon weapon;

    public BasicSilencer(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getDescription() {
        return weapon.getDescription() + " Basic Silencer";
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
