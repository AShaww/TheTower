package Guns;

public class SniperWeapon extends Weapon {

    public SniperWeapon() {
        description = "Chosen weapon is Sniper";
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
