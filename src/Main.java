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
        room.beginnerRoom(); // todo: the enemysystem or in the room add the actual code that saves us having beaten enemy
                            // todo: so when we say n and the come back enemy already dead...
        room2.secondRoom();
    }
}