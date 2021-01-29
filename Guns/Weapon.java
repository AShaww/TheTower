package Guns;

import Accessories.AccessoriesDec;

/**
 *
 * @author AmirS
 */
public abstract class Weapon {
    
    String description = "Unknown Weapon: ";
    
    /**
     *
     * @return description
     */
    public String getDescription(){
        return description;
    }
    //public abstract int bulletCount();

    /**
     *
     * @return weight
     */
    public abstract double weight();
    /**
     *
     * @return damage
     */
    public abstract int damage();
}