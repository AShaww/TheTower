package main;

import PlayerSingleton.PlayerSingleton;
import Guns.Weapon;
import java.util.*;

public class FireingRange {

    Weapon weapon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" -------------------------------------- ");
        System.out.println("        Text based Shooting Game        ");
        System.out.println(" -------------------------------------- ");
        System.out.println("Please Enter your name before Beginning*");

        String name = scanner.nextLine().toUpperCase();

        System.out.println("Thank you for joining this Adventure!: " + name);
        System.out.println();
        System.out.println(name + " to begin the game, first type a weapon you would like to play with:");
        System.out.println();
        System.out.println("\t'Shotgun' for Shotgun");
        System.out.println("\t'Sniper' for Sniper");
        System.out.println("\t'MP5' for MP5");
        String chooseWeapon = scanner.next().toUpperCase();

        while (!chooseWeapon.equals("MP5") && !chooseWeapon.equals("SHOTGUN") && !chooseWeapon.equals("SNIPER")) {
            System.out.println("\tIncorrect input, try again...");
            chooseWeapon = scanner.next().toUpperCase();
        }

        System.out.println();
        PlayerSingleton player = PlayerSingleton.getInstance(chooseWeapon, name);
        player.chosenWeapon();

        String[] enemies = {"Cowboy", "Wild Dog", "Thief", "Bounty Hunter", "Snake", "Killer Moth"};

        int MAX_ENEMY_HEALTH = 5;
        int MAX_ENEMY_ATTACK = 25;
        int enemyHP = MAX_ENEMY_HEALTH;
        int enemyDamage = MAX_ENEMY_ATTACK;

        int healthPotHealAmount = 50;
        int healthPotDropChance = 50;
        int numOfHealthPot = 3;

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int playerHP = player.getHealth();

        int basicAttachmentDropChance = 40;

        boolean isRunning = true;

        GAME:
        while (isRunning) {
            int enemyHealth = rand.nextInt(enemyHP);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " appeared! #\n");

            while (enemyHealth > 0) {
                System.out.println("\tYour HP:" + playerHP);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Use health potion");
                System.out.println("\t3.Run");
                System.out.println();

                String input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(player.getDamage());
                    int damageTaken = rand.nextInt(enemyDamage);
                    if (damageDealt == 0) {
                        System.out.println("You missed!");
                    } else {
                        System.out.println("\tHit " + enemy + " " + "Attacked for " + damageDealt);
                        playerHP -= damageTaken;
                    }
                    enemyHealth -= damageDealt;
                    player.sufferDamage(damageTaken);

                    if (playerHP == 0) {
                        player.respawn();
                        continue GAME;
                    }

                } else if (input.equals("2")) {
                    if (numOfHealthPot > 0) {
                        playerHP += healthPotHealAmount;
                        numOfHealthPot--;
                        System.out.println(" You drink a health potion, healing you for " + healthPotHealAmount);
                        System.out.println("\t You now have " + playerHP + " HP");
                        System.out.println("\t  You have " + numOfHealthPot + " left");
                    } else {
                        System.out.println("\t No more health potions! Defeat an enemy to have a chance of getting another one...");
                    }
                } else if (input.equals("3")) {
                System.out.println("\tYou exit the dungeon, successful form your adventure");
                break;
            } while (!input.equals("1") && !input.equals("2")&& !input.equals("3")) {
                System.out.println("Invalid command");
                input = in.nextLine();
            }
                
            }

            System.out.println(" -------------------------------------- ");
            System.out.println(" # " + enemy + " was defeated! #");
            System.out.println(" # You have " + playerHP + " HP left. #");

            if (rand.nextInt(100) < healthPotDropChance) {
                numOfHealthPot++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numOfHealthPot + " health potion(s). # ");

                if (rand.nextInt(100) < basicAttachmentDropChance) {
                    String[] attachments = {"silencer", "stock", "sight"};
                    String chooseAttachment = attachments[rand.nextInt(attachments.length)];

                    System.out.println("\tGained a random basic attachment: " + chooseAttachment);
                    player.addBasicAttachment(chooseAttachment);
                    player.chosenWeapon();
                }

            }

            System.out.println(" -------------------------------------- ");
            System.out.println("What would you like to do?");
            System.out.println("\t1. Continue playing?");
            System.out.println("\t2. Exit dungeon");
            
            String input = in.nextLine();
            
            while (!input.equals("1") && !input.equals("2")) {
                System.out.println("\tInvalid command");
                input = in.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("\tYou continue the adventure");
            } else if (input.equals("2")) {
                System.out.println("\tYou exit the dungeon, successful form your adventure");
                break;
            }
        }
        System.out.println("\t#########################################");
        System.out.println("\t           THANKS FOR PLAYING!           ");
        System.out.println("\t#########################################");
    }

}
