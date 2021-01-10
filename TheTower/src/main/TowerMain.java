package main;

import PlayerSingleton.PlayerSingleton;
import Guns.Weapon;
import MovementStrategy.*;
import java.util.*;
import Enemy.Enemies;
import Story.*;

/**
 *
 * @author AmirS Weeeeeee
 */
public class TowerMain {

    Weapon weapon;
    PlayerSingleton player;

    public static void main(String[] args) {

        Enemies enemys = new Enemies();
        
//      My working version of adding an enemy to List Object
//      enemys.addEnemy("**Test Enemy**");  //Testing method of adding enemy to list in Enemies class
//      Outputs: [Slime, Small Demon, Skeleton, Baby Dragon, Giant Snake, Behemoth, **Test Enemy**]  

        TellStory intro = new IntroStory();
        TellStory note = new NoteStory();
        TellStory halfway = new HalfwayMessage();
        TellStory out = new OutroStory();
        TellStory secondDoor = new ReachForSecondDoor();

//        MovementStrategy forward = new MoveForward();
//        MovementStrategy left = new MoveLeft();
//        MovementStrategy back = new MoveBackward();
//        forward.doMovement();
//        left.doMovement();
//        back.doMovement();
//        right.doMovement();
//        System.out.println(forward.doMovement());
//        System.out.println(left.doMovement());
//        System.out.println(back.doMovement());
//        System.out.println(right.doMovement());
//        #
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println(" --------------------- What is your name Soldier? --------------------");
        String name = scanner.nextLine().toUpperCase(); //casting name to uppercase

        intro.tellStory();  //Bringing the intro from another class.

        String chooseWeapon = scanner.next().toUpperCase();

        while (!chooseWeapon.equals("M") && !chooseWeapon.equals("R") && !chooseWeapon.equals("S")) {
            System.out.println("\tIncorrect input, try again...");
            chooseWeapon = scanner.next().toUpperCase();
        }
        System.out.println(" ----------------- Picking up a weapon you hear a voice ----------------");
        System.out.println(" ------------------- '" + name + " , your destiny awaits' ------------------- ");

        note.tellStory();    //Bringing the Note text from story class. Are you ready? 1. yes 2. no

        int ready = scanner.nextInt();
        System.out.println(" ############################################# ");

        while (ready != 1) {
            System.out.println(" ######################################### ");      //Return message for Note
            System.out.println(" Invalid Input");
            System.out.println("\t You have no where to go. The door behind you is locked... ");
            System.out.println("\t Are you ready?");
            System.out.println("\t '1' yes?");
            System.out.println(" ######################################### ");
            ready = scanner.nextInt();
        }
        
        secondDoor.tellStory();        
        
        PlayerSingleton player = PlayerSingleton.getInstance(chooseWeapon, name);
        player.chosenWeapon();
        System.out.println(" Player: " + player.getPlayerName() + " has: " + player.getHealth() + " health and " + player.getLives() + " lives");

        System.out.println(" ########################################## ");

        int healthPotHealAmount = 75;
        int healthPotDropChance = 50;
        int numOfHealthPot = 3;

        Scanner in = new Scanner(System.in);

        int grailStep = 20;     // Grail steps
        int randStep = rand.nextInt(grailStep); // Randomise grail step
        if (randStep <= 5) {    // If randStep is less than 5 randomise and add 2
            randStep = rand.nextInt(grailStep + 2);
        }
        int halfStep = randStep / 2;

        int playerHP = player.getHealth();
        int resetPlayerHP = playerHP;

        int eHealth = enemys.getEnemyHP();
        int eDamage = enemys.getEnemyDamage();
        int randEDamage = rand.nextInt(eDamage);

        int basicAttachmentDropChance = 40;
        int goodAttachmentDropChance = 25;

        boolean isRunning = true;

        GAME:       //Loop checkpoint, to return when player dies.
        while (isRunning) {
            System.out.println(" # Steps to to Grail " + randStep + " #");
            System.out.println(" ####################### ");
            
            int enemyHealth = rand.nextInt(eHealth);

            if (enemyHealth == 0) {         //Has to be == otherwise bound.Exception
                enemyHealth = rand.nextInt(eHealth);
            }
            String randomEnemy = enemys.randomEnemy();
            String enemy = randomEnemy;
            System.out.println("\t# " + enemy + " appeared! #\n");

            OUTER:
            while (enemyHealth > 0) {
                int playerLives = player.getLives();    // has to be inside loop to update value
                System.out.println("\tYour HP: " + playerHP);
                System.out.println("\tYour lives: " + playerLives);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t'1' Attack");
                System.out.println("\t'2' Use health potion");
                System.out.println();
                String input = in.nextLine();

                switch (input) {
                    case "1":
                        int damageDealt = rand.nextInt(player.getDamage());
                        int damageTaken = randEDamage;
                        if (damageDealt == 0) {
                            System.out.println("\tYou missed!");
                        } else {
                            System.out.println("\tYou hit " + enemy + " for " + damageDealt + " damage!");
                            playerHP -= damageTaken;
                        }
                        enemyHealth -= damageDealt;
                         System.out.println(String.format("\tEnemy hit you for %d damage!", damageTaken));
                        player.sufferDamage(damageTaken);
                        if (playerHP <= 0) {
                            System.out.println("\tYou Died");
                            playerHP = resetPlayerHP;
                            player.respawn();
                            continue GAME;  //Starts loop again from GAME:
                        }
                        break;
                    case "2":
                        if (numOfHealthPot > 0) {
                            playerHP += healthPotHealAmount;
                            numOfHealthPot--;
                            System.out.println(" You drink a health potion, healing you for " + healthPotHealAmount);
                            System.out.println();
                            System.out.println("\tYou now have " + playerHP + " HP");
                            System.out.println("\tYou have " + numOfHealthPot + " left");
                        } else {
                            System.out.println("\t No more health potions! Defeat an enemy to have a chance of getting another one...");
                        }
                        break;
                    default:
                        break;
                }
                while (!input.equals("1") && !input.equals("2")) {
                    System.out.println("Invalid command");
                    input = in.nextLine();
                }
            }
            randStep--;
            System.out.println(" ################################################### ");
            System.out.println(" Steps to to Grail " + randStep);
            System.out.println(" Player Info: " + player.getPlayerName() + " has: " + playerHP + " health and " + player.getLives() + " lives left.");
            System.out.println(" ################################################### ");
            
            if (randStep == halfStep) {
                halfway.tellStory();
            }
            
            System.out.println("--------------------------------------");
            System.out.println("# " + enemy + " was defeated! #");
            System.out.println("# You have " + playerHP + " HP left. #");
            System.out.println("--------------------------------------");

            if (rand.nextInt(100) < healthPotDropChance) {
                numOfHealthPot++;
                System.out.println(" ################################################### ");
                System.out.println(" # The " + enemy + " dropped a health potion!  ");
                System.out.println(" # You now have " + numOfHealthPot + " health potion. ");

                if (rand.nextInt(100) < basicAttachmentDropChance) {
                    String[] attachments = {"Sight", "Silencer", "Stock"};
                    String chooseAttachment = attachments[rand.nextInt(attachments.length)];
                    System.out.println(" # Gained a random Basic attachment: " + chooseAttachment);
                    player.addBasicAttachment(chooseAttachment);
                    player.chosenWeapon();
                }
                if (rand.nextInt(100) < goodAttachmentDropChance) {
                    String[] attachments = {"Sight", "Silencer", "Stock"};
                    String chooseAttachment = attachments[rand.nextInt(attachments.length)];
                    System.out.println(" # Gained a random Good attachment: " + chooseAttachment);
                    player.addGoodAttachment(chooseAttachment);
                    player.chosenWeapon();
                }
                System.out.println(" ################################################### ");
            }
            if (randStep == 0) {
                out.tellStory();
                break;
            }
        }
    }
}
