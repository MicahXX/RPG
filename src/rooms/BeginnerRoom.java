package rooms;

import gameLogic.playerSystem.Player;
import gameLogic.helperFunctions.Helper;
import gameLogic.enemySystem.Enemy;
import java.util.Scanner;

public class BeginnerRoom {

    private final Player player;
    private final Helper helper;
    private final Enemy enemy;
    private final Scanner input = new Scanner(System.in);

    public BeginnerRoom(Player player, Helper helper, Enemy enemy) {
        this.player = player;
        this.helper = helper;
        this.enemy = enemy;
    }

    public void beginnerScene() throws InterruptedException {
        helper.separators();
        System.out.println("MICAHS GAME");
        helper.separators();
        helper.timeout();
        System.out.println("WELCOME TO MY GAME!");
        Thread.sleep(1500);
        System.out.println("A really cool game (:");
        Thread.sleep(1500);
        helper.timeout();
    }

    public void beginnerDataInput() throws InterruptedException {
        System.out.print("How do you want to be called in-game: ");
        player.setName(input.nextLine());

        helper.loadingSystem();

        System.out.println("Well good luck " + player.getName() + ". I hope you will have fun on this journey.");
        helper.separators();
        helper.timeout();
    }

    public void roomOneMinigame() {
        // TODO: not sure how and what, but we will see
    }

    public void beginnerRoom() throws InterruptedException {
        System.out.println("Its a beautiful day today you think to yourself.");
        helper.timeout();
        System.out.print("Or is it?");
        helper.loadingSystemWithOnlyPoints();
        helper.timeout();
        System.out.println("Anyways you wake up in a small room and stand up to begin your day.");
        helper.timeout();
        helper.separators();

        boolean passed = false;
        boolean exitFight = false;
        boolean moneyOption = true;

        while (!passed) {
            System.out.print("Where do you want to move to? w/a/s/d: ");
            String moveOption = input.nextLine().toLowerCase();

            switch (moveOption) {
                case "w":
                    if (moneyOption) {
                        helper.setAndGetNewBalance(5);
                        moneyOption = false;
                    } else {
                        System.out.println("You already got everything here.");
                    }
                    helper.separators();
                    break;

                case "a":
                    System.out.print("There was nothing");
                    helper.loadingSystemWithOnlyPoints();
                    helper.separators();
                    break;

                case "s":
                    roomOneMinigame();
                    break;

                case "d":
                    System.out.print("The exit is here, but an enemy is guarding it. Continue? y/n: ");
                    String answer = input.nextLine().toLowerCase();

                    switch (answer) {
                        case "n":
                            exitFight = true;
                            System.out.print("You got away");
                            helper.loadingSystemWithOnlyPoints();
                            helper.separators();
                            break;
                        case "y":
                            break;
                        default:
                            exitFight = true;
                            System.out.println("Invalid Input");
                            System.out.println("Default to 'n'.");
                            helper.separators();
                            break;
                    }

                    if (exitFight) {
                        exitFight = false;
                        break;
                    }

                    enemy.enemyDuelSystem("Rat", 3, 0.5, 2);   // enemy.enemyDuelSystem()

                    System.out.println("You are able to enter room 2!");
                    System.out.print("Do you want to enter room 2? y/n: ");
                    String advanceChoice = input.nextLine().toLowerCase();

                    if (advanceChoice.equals("y")) {
                        passed = true;
                    } else {
                        System.out.println("You decide to stay a while longer.");
                    }
                    break;

                default:
                    System.out.println("Invalid direction.");
                    break;
            }
        }
    }
}