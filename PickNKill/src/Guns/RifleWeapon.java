package Guns;

public class RifleWeapon extends Weapon {

    public RifleWeapon() {
        description = "Chosen weapon is Rifle";
    }

    @Override
    public double weight() {
        return 25;
    }

    @Override
    public int damage() {
        return 53;
    }

}
