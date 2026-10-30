import gameLogic.playerSystem.Player;
import gameLogic.helperFunctions.Helper;
import gameLogic.enemySystem.Enemy;
import gameLogic.roomLogic.Rooms;
import rooms.BeginnerRoom;
import rooms.SecondRoom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("", 10, 1, 10, null);
        Helper helper = new Helper(player);
        Enemy enemy = new Enemy(player, helper);
        Rooms rooms = new Rooms(helper);
        BeginnerRoom room = new BeginnerRoom(player, helper, enemy, rooms);
        SecondRoom room2 = new SecondRoom(player, helper, enemy);

        // Intro, bedroom, 4 choices (w,a,s,d), rat encounter/fight (bossfight kinda)
        room.beginnerScene();
        room.beginnerDataInput();
        room.beginnerRoom(); // todo: fix minigame bugs and other minor issues

        // living room, encounter with mom
        room2.secondRoom(); // I need to think of a better story man

        // todo: make more rooms
    }
}