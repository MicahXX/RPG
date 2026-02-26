package gameLogic.playerSystem;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private double health;
    private double attackDamage;
    private int money;
    private List<String> inventory;

    public Player(String name, double health, double attackDamage, int money, List<String> inventory) {
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
}
