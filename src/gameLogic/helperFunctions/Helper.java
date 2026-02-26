package gameLogic.helperFunctions;

import gameLogic.playerSystem.*;

public class Helper {
    private final Player player;

    public Helper(Player player) {
        this.player = player;
    }

    public void separators() {
        System.out.println("-------------------------------");
    }

    public void loadingSystem() {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                timeout();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public void loadingSystemWithOnlyPoints() {
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            try {
                timeout();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }

    public void timeout() throws InterruptedException {
        Thread.sleep(1000);
    }

    public void setAndGetNewBalance(int moneyAmount) throws InterruptedException {
        player.setMoney(player.getMoney() + moneyAmount);
        if (moneyAmount > 1) {
            System.out.println("You acquired " + moneyAmount + " dollars.");
        } else {
            System.out.println("You acquired one dollar.");
        }
        timeout();
        System.out.println("You now have: " + player.getMoney() + " dollars.");
        timeout();
    }
}