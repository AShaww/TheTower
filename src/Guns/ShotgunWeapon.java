package Guns;

public class ShotgunWeapon extends Weapon {

    public ShotgunWeapon() {
        description = "Chosen weapon is Shotgun";
    }

    @Override
    public double weight() {
        return 20;
    }

    @Override
    public int damage() {
        return 35;
    }
}
