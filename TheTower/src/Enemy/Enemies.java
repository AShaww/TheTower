package Enemy;

import java.util.*;

public class Enemies {

    List<String> enemyList = Arrays.asList("Slime", "Small Demon", "Skeleton", "Baby Dragon", "Giant Snake", "Behemoth");
    Random rand = new Random();

    int MAX_ENEMY_HEALTH = 100;
    int MAX_ENEMY_ATTACK = 60;
    int enemyHP = MAX_ENEMY_HEALTH;
    int enemyDamage = MAX_ENEMY_ATTACK;

    public String randomEnemy() {
        int randEnemy = rand.nextInt(enemyList.size());
        String randomEnemy = enemyList.get(randEnemy);
        return randomEnemy;
    }

    public int randEDamage() {
        int randDamage = rand.nextInt(enemyDamage);
        return randDamage;
    }

    public int randEHealth() {
        int randHealth = rand.nextInt(enemyHP);
        return randHealth;
    }

    public List<String> getEnemyList() {
        return enemyList;
    }

    public void setEnemyList(List<String> enemyList) {
        this.enemyList = enemyList;
    }

    public int getEnemyHP() {
        return enemyHP;
    }

    public void setEnemyHP(int enemyHP) {
        int randHealth = rand.nextInt(enemyHP);
        this.enemyHP = randHealth;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

}
