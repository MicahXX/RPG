package gameLogic.roomLogic;

import gameLogic.helperFunctions.Helper;

import java.util.Scanner;

public class Rooms {
    private final Helper helper;
    private final Scanner input = new Scanner(System.in);
    private boolean isCompleted = false;

    public Rooms(Helper helper) {
        this.helper = helper;
    }

    public void roomDefaultMinigame(int moneyEarned) throws InterruptedException {

        if (!isCompleted) {
            helper.separators();
            System.out.println("You find a mouse that asks you to choose between the number 1 or 2.");
            System.out.println("The little mouse explains that if you guess right he would reward you.");
            helper.separators();
            System.out.print("What do you choose? (1 or 2): ");
            int choice = input.nextInt();

            double correctNumber = Math.random();

            // my ahh logic to choose 0 or 1
            if (correctNumber > 0.5) {
                correctNumber = 2;
            } else if (correctNumber < 0.5)  {
                correctNumber = 1;
            } else  {
                System.out.println("you are unlucky ig.");
                correctNumber = -1;
            }

            // there stil seems to be some kind of bug here
            switch ((int) correctNumber) {
                case 1:
                    if (correctNumber == choice) {
                        System.out.println("You guessed right he rewards you.");
                        helper.setAndGetNewBalance(moneyEarned);
                    }
                    break;
                case 2:
                    if (correctNumber != choice) {
                        System.out.println("You guessed wrong he runs away.");
                        helper.loadingSystem();
                    }
                    break;
                default:
                    System.out.println("How?");
            }
            isCompleted = true;
        } else {
            System.out.println("You have finished the minigame there is nothing left.");
            helper.loadingSystem();
        }
    }
}
