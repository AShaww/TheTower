package Guns;

public abstract class Weapon {
    
    String description = "Unknown Weapon: ";
    
    public String getDescription(){
        return description;
    }
    //public abstract int bulletCount();
    public abstract double weight();
    public abstract int damage();
}