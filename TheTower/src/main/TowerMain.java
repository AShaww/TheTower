package main;

import PlayerSingleton.PlayerSingleton;
import Guns.Weapon;
import java.util.*;

public class TowerMain {

    Weapon weapon;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" --------------------- What is your name Soldier? --------------------");
        String name = scanner.nextLine().toUpperCase();
        System.out.println("----------------------------------------------------------------------- ");
        System.out.println(" -- You look up to see a large inconspicuous tower with a small door -- ");
        System.out.println(" ---------------------------------------------------------------------- ");
        System.out.println(" -------------------- You decide to squeeze through ------------------- ");
        System.out.println(" ------------- The door shuts behind you with a loud bang ------------- ");
        System.out.println(" - Upon entering you see a chest, intrigued you walk over and peer in - ");
        System.out.println(" ------- inside you see some weapons, deciding on which to pick ------- ");
        System.out.println();
        System.out.println("########################################################################");
        System.out.println(" ----------------- Type a letter to select a weapon ------------------- ");
        System.out.println();
        System.out.println(" --- Enter 'S' for Shotgun");
        System.out.println(" --- Enter 'R' for Rifle");
        System.out.println(" --- Enter 'M' for MP5");
        System.out.println("########################################################################");
        String chooseWeapon = scanner.next().toUpperCase();

        while (!chooseWeapon.equals("M") && !chooseWeapon.equals("R") && !chooseWeapon.equals("S")) {
            System.out.println("\tIncorrect input, try again...");
            chooseWeapon = scanner.next().toUpperCase();
        }
        System.out.println(" ----------------- Picking up a weapon you hear a voice ----------------");
        System.out.println(" ------------------- '" + name + " , your destiny awaits' ------------------- ");
        System.out.println(" ------- 'Venture through the tower and find the Holy Grail' -------- ");
        System.out.println(" -- Wipe out the enemies, find it and save the tower from corruption -- ");
        System.out.println();
        System.out.println(" -------- Beside the weapon chest, you see two health potions --------- ");
        System.out.println(" --------- You see a note when picking up the health potions ---------- ");
        System.out.println(" -----------------------------------------------------------------------");
        System.out.println(" - \" You have entered the tower, you are expected to survive through- -");
        System.out.println(" -- do not question it, you are meant to be here. It is your destiny --");
        System.out.println(" -- Do not faulter, make your way through the tower and find the Grail --");
        System.out.println(" --- I have left the health potions here, for you to use in times of- ---");
        System.out.println(" - emergency, use them when you are losing in battle, regenerate your- -");
        System.out.println(" ------------------ vitality, and destroy your enemy ------------------- ");
        System.out.println(" --------------- Find the grail and stop this madness. ----------------- ");
        System.out.println(" ---------------------------- Signed - .RS\" -----------------------------");
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println(" ------ Upon reading the note, you hear a mechanism start to move ------ ");
        System.out.println(" ----------------- You put the note in your back pocket -----------------");
        System.out.println();
        System.out.println(" ---- Tracking the sound, you find a door that was not there before ----");
        System.out.println(" -------- Deciding if you are ready to approach the door... --------");
        System.out.println(" ###################################################################### ");
        System.out.println(" --- Are you ready? --- ");
        System.out.println(" .1 'yes'");
        System.out.println(" .2 'no'");
        System.out.println(" ###################################################################### ");
        int ready = scanner.nextInt();
        System.out.println(" ------------------------------------------------------------------------ ");
        while (ready != 1) {
            System.out.println(" ###################################################################### ");
            System.out.println(" Invalid Input");
            System.out.println("\t You have no where to go. The door behind you is locked... ");
            System.out.println("\t Are you ready?");
            System.out.println("\t '1' yes?");
            System.out.println(" ###################################################################### ");
            ready = scanner.nextInt();
        }
        System.out.println(" ------------------------------------------------------------------------------ ");
        System.out.println(" ----- you reach for the door, and push hard... It swings open, you enter ----- ");
        System.out.println(" -- A strong gust of wind closes the door behind you, hearing the mechanism- -- ");
        System.out.println(" ----------------- You know that the door has locked itself ------------------- ");
        System.out.println(" ------------------------------------------------------------------------------ ");
        System.out.println(" ################################################################################### ");
        PlayerSingleton player = PlayerSingleton.getInstance(chooseWeapon, name);
        player.chosenWeapon();

        String[] enemies = {"Slime", "Small Demon", "Skeleton", "Baby Dragon", "Giant Snake", "Behemoth"};

        int MAX_ENEMY_HEALTH = 100;
        int MAX_ENEMY_ATTACK = 50;
        int enemyHP = MAX_ENEMY_HEALTH;
        int enemyDamage = MAX_ENEMY_ATTACK;

        int healthPotHealAmount = 50;
        int healthPotDropChance = 50;
        int numOfHealthPot = 3;

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        int grailStep = 10;     // grail steps

        int randStep = rand.nextInt(grailStep);

        int halfStep = randStep / 2;

        int playerHP = player.getHealth();
        int copyPlayerHP = playerHP;

        int basicAttachmentDropChance = 40;
        int goodAttachmentDropChance = 25;

        boolean isRunning = true;

        GAME:
        while (isRunning) {

            int enemyHealth = rand.nextInt(enemyHP);

            if (enemyHealth == 0) {
                enemyHealth = rand.nextInt(enemyHP);
            }
            String enemy = enemies[rand.nextInt(enemies.length)];
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
                        int damageTaken = rand.nextInt(enemyDamage);
                        if (damageDealt == 0) {
                            System.out.println("\tYou missed!");
                        } else {
                            System.out.println("\tYou hit " + enemy + " for " + damageDealt + " damage!");
                            playerHP -= damageTaken;
                        }
                        enemyHealth -= damageDealt;
                        player.sufferDamage(damageTaken);
                        if (playerHP <= 0) {
                            System.out.println("\tYou Died");
                            playerHP = copyPlayerHP;
                            player.respawn();
                            continue GAME;
                        }
                        break;
                    case "2":
                        if (numOfHealthPot > 0) {
                            playerHP += healthPotHealAmount;
                            numOfHealthPot--;
                            System.out.println(" You drink a health potion, healing you for " + healthPotHealAmount);
                            System.out.println("\t You now have " + playerHP + " HP");
                            System.out.println("\t  You have " + numOfHealthPot + " left");
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
            System.out.println("Steps to to Grail " + randStep);
            if (randStep == halfStep) {
                System.out.println("\t#############################################################################");
                System.out.println("\t####            You are halway through the tower - keep going!           #### ");
                System.out.println("\t#############################################################################");
            }
            System.out.println(" -------------------------------------- ");
            System.out.println("\t # " + enemy + " was defeated! #");
            System.out.println("\t # You have " + playerHP + " HP left. #");
            System.out.println(" -------------------------------------- ");

            if (rand.nextInt(100) < healthPotDropChance) {
                numOfHealthPot++;
                System.out.println(" # The " + enemy + " dropped a health potion! # ");
                System.out.println(" # You now have " + numOfHealthPot + " health potion(s). # ");

                if (rand.nextInt(100) < basicAttachmentDropChance) {
                    String[] attachments = {"Sight", "Silencer", "Stock"};
                    String chooseAttachment = attachments[rand.nextInt(attachments.length)];

                    System.out.println("Gained a random Basic attachment: " + chooseAttachment);
                    player.addBasicAttachment(chooseAttachment);
                    player.chosenWeapon();
                }
                if (rand.nextInt(100) < goodAttachmentDropChance) {
                    String[] attachments = {"Sight", "Silencer", "Stock"};
                    String chooseAttachment = attachments[rand.nextInt(attachments.length)];
                    System.out.println("Gained a random Good attachment: " + chooseAttachment);
                    player.addGoodAttachment(chooseAttachment);
                    player.chosenWeapon();
                }
            }

            if (randStep == 0) {
                System.out.println("\t############################################################################################################################");
                System.out.println("\t- After killing the last enemy, A chest and a basin appear in the middle of the room -");
                System.out.println("\t- Huffing and panting you exhaustedly make your way to the chest. Realising what- -");
                System.out.println("\t- it took to get here, remembering the instructions on the note found at the beginning- -");
                System.out.println("\t- of the tower, you open the chest. Near blinded by the light presented from the object- -");
                System.out.println("\t- you reach in and pick up the grail. Examing the grail for a moment you realise the inscription -");
                System.out.println("\t-  'calix impletus aqua bibere' below the Latin inscription you see a translation 'The cup was filled with water to drink' -");
                System.out.println("\t- Realising the basin beside the chest, you fill the grail and drink. -");
                System.out.println("\t- You close your eyes, and you feel a gust of wind. The feeling of moving comes over you -");
                System.out.println("\t- Opening your eyes you realise that now you are in a room, within a bed. Like a dream that you remember -");
                System.out.println("\t- Not knowing how you got there, but remembering what you did. You hope you can visit the dreamscape again the next time you- -");
                System.out.println("\t close your eyes to sleep. ");
                System.out.println("\t############################################################################################################################");
                break;
            }
        }
    }
}
