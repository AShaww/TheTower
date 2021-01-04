package Accessories;

import Guns.Weapon;

public class BasicSight extends AccessoryDecorator {
    Weapon weapon;
    
    public BasicSight(Weapon weapon) {
        this.weapon = weapon;
    }
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Basic Sight";
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
