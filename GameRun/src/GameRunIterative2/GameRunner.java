package GameRunIterative2;

interface GamingConsole {
    public void play();
}

class Mario implements GamingConsole{
    @Override
    public void play() {
        System.out.println("Playing Mario");
    }
}

class SuperContra implements GamingConsole{
    @Override
    public void play() {
        System.out.println("Playing SuperContra");
    }
}

class Pacman implements GamingConsole{
    @Override
    public void play() {
        System.out.println("Playing Pacman");
    }
}

public class GameRunner {
    private GamingConsole gamingConsole;
    public static void main(){

    }
}
