package Accessories;

import Guns.Weapon;

/**
 *
 * @author AmirS
 */
public class BasicSight extends AccessoriesDec {
    Weapon weapon;
    
    /**
     *
     * @param weapon
     */
    public BasicSight(Weapon weapon) {
        this.weapon = weapon;
    }
    /**
     *
     * @return accessory description
     */
    @Override
    public String getDescription() {
        return weapon.getDescription() + ", Basic Sight";
    } 

    /**
     *
     * @return accessory weight
     */
    @Override
    public double weight() {
        return 7 + weapon.weight();
    }
    
    /**
     *
     * @return accessory damage
     */
    @Override
    public int damage() {
        return 7 + weapon.damage();
   }


}
