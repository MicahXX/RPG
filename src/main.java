void main() throws InterruptedException {
    Game game = new Game(null, 10.0, 1.0, 10, null);

    game.beginnerScene();
    game.beginnerDataInput();
    game.beginnerRoom();

    System.out.println(game.getMoney());
    System.out.println(game.getHealth());
}