import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    Scanner input = new Scanner(System.in);

    String name;
    double health;
    double attackDamage;
    int money;
    List<String> inventory;

    public Game(String name, double health, double attackDamage, int money, List<String> inventory) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.money = money;
        this.inventory = (inventory != null) ? inventory : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(double attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public void setInventory(List<String> inventory) {
        this.inventory = inventory;
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
        money = money + moneyAmount;
        if (moneyAmount > 1) {
            System.out.println("You acquired " + moneyAmount + " dollars.");
        } else {
            System.out.println("You acquired one dollar.");
        }
        timeout();
        System.out.println("You now have: " + getMoney() + " dollars.");
    }

    // todo: implement a short minigame which an user can do do a reward
    public void roomOneMinigame() {

    }

    // todo: general enemy system for the whole game
    public void enemyDuelSystem(String enemyName, double enemyHealth, double enemyAttackDamage, int rewardedMoney) throws InterruptedException {
        int turns = 1;

        separators();
        System.out.println(getName() + " encounters an " + enemyName + ".");
        System.out.println("Stats: " + enemyHealth + " HP, " + enemyAttackDamage + " AP");

        while (enemyHealth > 0 && getHealth() > 0) {
            separators();
            System.out.println("Turn: " + turns);
            System.out.print("What do you want to do? (attack / flee / ownstats / ?): ");
            String option = input.nextLine().toLowerCase();
            switch (option) {
                case "attack":
                    enemyHealth = Math.max(0, enemyHealth - getAttackDamage());
                    timeout();
                    separators();
                    System.out.println("You dealt " + getAttackDamage() + " damage.");
                    timeout();
                    System.out.println("Remaining enemy HP: " + enemyHealth);

                    if (enemyHealth > 0) {
                        timeout();
                        separators();
                        System.out.println("Enemy is attacking you.");
                        timeout();
                        setHealth(Math.max(0, getHealth() - enemyAttackDamage));
                        timeout();
                        System.out.println("You got hit by the enemy. (-" + enemyAttackDamage + " HP)");
                        timeout();
                        if (getHealth() > 0) {
                            System.out.println("Own HP left: " + getHealth());
                        }
                    }
                    turns++;
                    break;
                case "flee":
                    System.out.println("You got away!");
                    return;
                case "ownstats":
                    System.out.println("Stats: " + getHealth() + " HP, " + getAttackDamage() + " AP");
                    break;
                case "?":
                    System.out.println("HP - Health Points, AP - Attack Points");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        if (getHealth() <= 0) {
            System.out.print("You lost");
            loadingSystemWithOnlyPoints();
            System.exit(0);
            return;
        }

        money += rewardedMoney;
        System.out.println("You won!!!");
    }

    // todo: add colors, more text...
    public void beginnerScene() throws InterruptedException {
        separators();
        System.out.println("MICAHS GAME");
        separators();
        timeout();
        System.out.println("WELCOME TO MY GAME!");
        Thread.sleep(1500);
        System.out.println("A really cool game (:");
        Thread.sleep(1500);
        timeout();
    }

    public void beginnerDataInput() throws InterruptedException {
        System.out.print("How do you want to be called in-game: ");
        name = input.nextLine();

        loadingSystem();

        System.out.println("Well good luck " + name + ". I hope you will have fun on this journey.");
        separators();
        timeout();
    }

    public void beginnerRoom() throws InterruptedException {
        System.out.println("Its a beatiful day today you think to yourself.");
        timeout();
        System.out.print("Or is it?");
        loadingSystemWithOnlyPoints();
        timeout();
        System.out.println("Anyways you wake up in a small room and stand up to begin your day.");
        timeout();
        separators();
        System.out.print("Where do you want to move to? w/a/s/d: ");
        String moveOption = input.nextLine().toLowerCase();

        switch (moveOption) {
            case "w":
                setAndGetNewBalance(5);
                separators();
                break;
            case "a":
                System.out.println("There was nothing");
                loadingSystemWithOnlyPoints();
                break;
            // todo: both of these options of these systems
            case "s":
                roomOneMinigame();
                break;
            case "d":
                enemyDuelSystem("Rat", 3, 0.5, 2);
                break;
        }
    }
}