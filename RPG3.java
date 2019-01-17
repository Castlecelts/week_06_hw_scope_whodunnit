package RPG;

import java.util.Random;
import java.util.Scanner;

public class RPG3 {
	public static void main(String[] args) {
		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();		
		

		// Game variables
		String[] undeads = {"Deadie", "Forsaken", "Skeleton", "Zombie"};
		String[] animals = {"Cave Bear", "Cave Wolf", "Lizard", "Giant Bat"};
		String[] humanoids = {"Warrior", "Bandit", "Mage", "Assassin"};
		String[][] enemies = {undeads, animals, humanoids};		
		String[] victim = { "Princess", "Old Queen", "Maid", "Frog"};
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		int enemyKillCount = 0;

		// Player variables
		int health = 100;
		int attackDmg = 45;
		int numHealthPots = 3;
		int numAttPots = 0;
		int attackPotionBoost = 5;
		int attackPotionDropChance = 20; 
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 40; // Percentage

		boolean running = true;
		System.out.println("Welcome to the dungeon!");

		GAME: while (running) {
			System.out.println("--------------------------------------");

			int enemyHealth = rand.nextInt(maxEnemyHealth);
			int enemyArmour;
			int damageDealt0;
			String enema[] = enemies[rand.nextInt(enemies.length)];
			String enemy = enema[rand.nextInt(enema.length)];
			
			System.out.println("\t# " + enemy + " has appeared! #\n");

			while (enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run");
				String input = in.nextLine();
				
				if (enema.equals(undeads)){
					enemyArmour = 5;
				}
				if (enema.equals(humanoids)){
					enemyArmour = 15;
				}
				else enemyArmour = 2;

				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDmg);
					damageDealt0 = damageDealt-enemyArmour;
					damageDealt0 = Math.max(0, damageDealt);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					enemyHealth -= damageDealt0;
					health -= damageTaken;
					
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt0 + " damage");
					System.out.println("\t> You recieved " + damageTaken + " in retaliation");
					if (health < 1) {
						System.out.println("\t You have taken too much damage, you are too weak to go on");
						break;
					}
				} else if (input.equals("2")) {
					if (numHealthPots > 0) {
						health += healthPotionHealAmount;
						numHealthPots--;
						System.out.println("\t> You drank a health potion, healed for: " + healthPotionHealAmount + "."
								+ "\n\t> You now have" + health + "HP." + "\n\t> You now have" + numHealthPots
								+ " health potions left.\n");
					} else {
						System.out.println("\t> You have no health potions, defeat enemies for a chance to get one");
					}
				} else if (input.equals("3")) {
					System.out.println("\t> You run away from the " + enemy);
					continue GAME;
				} else {
					System.out.println("\tInvalid command");
				}
			}
			if (health < 1) {
				System.out.println("You limp out of the dungeon, weak from battle.");
				break;
			}
			enemyKillCount++;
			System.out.println("----------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + "HP left # ");
			System.out.println(" # Enemies killed: " + enemyKillCount);

			if (rand.nextInt(100) < healthPotionDropChance) {
				numHealthPots++;
				System.out.println(" # The " + enemy + " dropped a health potion. # ");
				System.out.println(" # You now have " + numHealthPots + " health potion(s). # ");
			}
			if (rand.nextInt(100) < attackPotionDropChance) {
				numAttPots++;
				System.out.println(" # The " + enemy + " dropped a attack potion. # ");
				System.out.println(" # You now have " + numAttPots + " attack potion(s). # ");
			}
			System.out.println("--------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Drink attack potion");
			System.out.println("3. Exit dungeon");
			String input = in.nextLine();
			while (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
				System.out.println("invalid command");
				input = in.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("You continue your adventure.");
			} 
			else if (input.equals("2")) {
				if (numAttPots > 0) {
					attackDmg += attackPotionBoost;
					numAttPots--;
					System.out.println("You drink the attack potion.");
				} else {
					System.out.println("\t> You have no attack potions, defeat enemies for a chance to get one");
				}
			} else if (input.equals("3")) {
				System.out.println("You exit the dungeon. ");
				break;
			}
			
			if (enemyKillCount== 5){
				String victimC = victim[rand.nextInt(victim.length)];
				System.out.println("You find captured " + victimC);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Kiss");
				System.out.println("\t2. Run");
				String inpute = in.nextLine();
				while (!inpute.equals("1") && !inpute.equals("2")) {
					System.out.println("invalid command");
					inpute = in.nextLine();
				}
				if (inpute.equals("1")) {
					System.out.println("It became or stayed a frog.");
					break;
				} else if (inpute.equals("2")) {
					System.out.println("You exit the dungeon.");
					break;
				}
				
			}
			
			
			
			
			
		}

		System.out.println("######################");
		System.out.println("# THANKS FOR PLAYING #");
		System.out.println("######################");
	}
}

