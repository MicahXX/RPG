package gameLogic.enemySystem;

import gameLogic.helperFunctions.*;
import gameLogic.playerSystem.*;
import java.util.Scanner;

public class Enemy {
    private final Player player;
    private final Helper helper;
    private final Scanner input = new Scanner(System.in);

    public Enemy(Player player, Helper helper) {
        this.player = player;
        this.helper = helper;
    }

    public void enemyDuelSystem(String enemyName, double enemyHealth, double enemyAttackDamage, int rewardedMoney) throws InterruptedException {
        int turns = 1;

        helper.separators();
        System.out.println(player.getName() + " encounters a " + enemyName + ".");
        System.out.println("Stats: " + enemyHealth + " HP, " + enemyAttackDamage + " AP");

        while (enemyHealth > 0 && player.getHealth() > 0) {
            helper.separators();
            System.out.println("Turn: " + turns);
            System.out.print("What do you want to do? attack(a or 1) / flee(f or 2) / ownstats(o or 3) / ? or 0: ");
            String option = input.nextLine().toLowerCase();

            switch (option) {
                case "attack":
                case "a":
                case "1":
                    enemyHealth = Math.max(0, enemyHealth - player.getAttackDamage());
                    helper.timeout();
                    helper.separators();
                    System.out.println("You dealt " + player.getAttackDamage() + " damage.");
                    helper.timeout();
                    System.out.println("Remaining enemy HP: " + enemyHealth);

                    if (enemyHealth > 0) {
                        helper.timeout();
                        helper.separators();
                        System.out.println("Enemy is attacking you.");
                        helper.timeout();
                        player.setHealth(Math.max(0, player.getHealth() - enemyAttackDamage));
                        helper.timeout();
                        System.out.println("You got hit! (-" + enemyAttackDamage + " HP)");
                        helper.timeout();
                        if (player.getHealth() > 0) {
                            System.out.println("Own HP left: " + player.getHealth());
                        }
                    }
                    turns++;
                    break;

                case "flee":
                case "f":
                case "2":
                    System.out.println("You got away!");
                    return;

                case "ownstats":
                case "o":
                case "3":
                    System.out.println("Stats: " + player.getHealth() + " HP, " + player.getAttackDamage() + " AP");
                    break;

                case "?":
                case "0":
                    System.out.println("HP - Health Points, AP - Attack Points");
                    System.out.println("attack - attack the enemy");
                    System.out.println("flee - run from the fight");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        if (player.getHealth() <= 0) {
            System.out.print("You lost");
            helper.loadingSystemWithOnlyPoints();
            System.exit(0);
            return;
        }

        System.out.println("You won!!!");
        System.out.println("Old money: " + player.getMoney() + " (+" + rewardedMoney + ")");
        player.setMoney(player.getMoney() + rewardedMoney);
        System.out.println("New amount: " + player.getMoney());
        helper.separators();
    }
}