package Enemy;

import java.util.*;

/**
 *
 * @author AmirS
 */
public class Enemies {

    List<String> enemyList = new ArrayList<>(Arrays.asList("Slime", "Small Demon", "Skeleton", "Baby Dragon", "Giant Snake", "Behemoth"));   // Just made a List instead of creating multiple enemy inherited classes.

    Random rand = new Random();
/**
     * The value of MAX_ENEMY_LIVES {@value #MAX_ENEMY_HEALTH}
     */
    private static final int MAX_ENEMY_HEALTH = 100;
    /**
     * The value of MAX_ENEMY_ATTACK {@value #MAX_ENEMY_ATTACK}
     */
    private static final int MAX_ENEMY_ATTACK = 60;
    private static int enemyHP = MAX_ENEMY_HEALTH;
    private static int enemyDamage = MAX_ENEMY_ATTACK;

    /**
     *
     * @return enemyList, then randomises value from list using int of size of list.
     */
    public String randomEnemy() {
        int randEnemy = rand.nextInt(enemyList.size());
        String randomEnemy = enemyList.get(randEnemy);
        return randomEnemy;
    }

    //Getters and setters for damage/Health and array of enemy string
    /**
     *
     * @return enemyList
     */
    public List<String> getEnemyList() {
        return enemyList;
    }

    /**
     *
     * @return enemyHP
     */
    public int getEnemyHP() {
        return enemyHP;
    }

    /**
     *
     * @param enemyHP
     */
    public void setEnemyHP(int enemyHP) {
        int randHealth = rand.nextInt(enemyHP);
        this.enemyHP = randHealth;
    }

    /**
     *
     * @return enemyDamage
     */
    public int getEnemyDamage() {
        return enemyDamage;
    }

    /**
     *
     * @param enemyDamage
     */
    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    /**
     *
     * @param enemyName
     * @return enemyList
     */
    public List<String> addEnemy(String enemyName) {
        enemyList.add(enemyName);
        System.out.println(enemyList);
        return enemyList;
    }

}
