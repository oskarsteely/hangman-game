import java.util.Scanner;

public class Game {
    private Words words;
    private String wordToGuess;
    private Settings settings;
    private Scanner input;

    public Game() {
        input = new Scanner(System.in);
    }

    public void start() {
        settings.playerNickname();


    }
}
