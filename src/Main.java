import gameLogic.playerSystem.Player;
import gameLogic.helperFunctions.Helper;
import gameLogic.enemySystem.Enemy;
import rooms.BeginnerRoom;
import rooms.SecondRoom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("", 10, 1, 10, null);
        Helper helper = new Helper(player);
        Enemy enemy = new Enemy(player, helper);
        BeginnerRoom room = new BeginnerRoom(player, helper, enemy);
        SecondRoom room2 = new SecondRoom(player, helper, enemy);

        room.beginnerScene();
        room.beginnerDataInput();
        room.beginnerRoom(); // todo: add the minigame
        room2.secondRoom();
    }
}