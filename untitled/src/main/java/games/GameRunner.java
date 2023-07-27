package games;

public class GameRunner {
    private GameConsole myGameConsole;
    public GameRunner(GameConsole game){
        this.myGameConsole = game;
    }

    public void run(){
        this.myGameConsole.up();
    }
}
