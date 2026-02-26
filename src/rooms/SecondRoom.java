package rooms;

import gameLogic.playerSystem.Player;
import gameLogic.helperFunctions.Helper;
import gameLogic.enemySystem.Enemy;
import java.util.Scanner;

public class SecondRoom {
    private final Player player;
    private final Helper helper;
    private final Enemy enemy;
    private final Scanner input = new Scanner(System.in);

    public SecondRoom(Player player, Helper helper, Enemy enemy) {
        this.player = player;
        this.helper = helper;
        this.enemy = enemy;
    }

    public void secondRoom() throws InterruptedException {
        helper.separators();
        System.out.println("You enter the living room.");
        helper.timeout();
        System.out.println("My mother is here, " + player.getName() + " thinks.");
        helper.timeout();
        // todo: yeah story telling aint my thing...
        // todo: split rooms in diff .jar up etc and the systems, also improve code/make more functions.
    }
}
