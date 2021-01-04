package Guns;

public class MP5Weapon extends Weapon {

    public MP5Weapon() {
        description = "Chosen weapon is MP5";
    }

    @Override
    public double weight() {
        return 12;
    }

    @Override
    public int damage() {
        return 13;
    }
}
