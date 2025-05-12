import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Settings settings;
    private Words words;
    private String wordToGuess;
    private Scanner input;
    private int lives;
    private List<String> usedLetters;
    StringBuilder wordGuess;

    public Game() {
        input = new Scanner(System.in);
        usedLetters = new ArrayList<>();
        settings = new Settings();
        words = new Words();
    }

    private void usedLettersUI() {
        System.out.print("Used letters: ");
        for (int i = 0; i < usedLetters.size(); i++) {
            System.out.print(usedLetters.get(i) + ", ");
        }
    }

    private void wordGuessUI() {
        wordGuess = new StringBuilder(wordToGuess);
        for (int i = 0; i < wordGuess.length(); i++) {
            wordGuess.setCharAt(i, '_');
        }
        System.out.print("\n" + wordGuess.length() + " letter word: " + wordGuess);
    }

    public void start() {
        settings.apply();
        settings.playerNickname();
        wordToGuess = words.getWord();
        lives = settings.getLives();

        while (lives > 0) {
            usedLettersUI();
            wordGuessUI();
            System.out.println("\nLives: " + lives + " ");

            while (true) {
                try {
                    System.out.print("Take a guess: ");
                    String guess = input.nextLine();

                    if (guess.length() != 1) {
                        throw new IllegalArgumentException("Please enter a single letter!");
                    }

                    if (!Character.isLetter(guess.charAt(0))) {
                        throw new IllegalArgumentException("Invalid input: Numbers are not allowed. Please enter a letter.");
                    }

                    if (usedLetters.contains(guess)) {
                        throw new IllegalArgumentException("This letter has already been used.");
                    }

                    boolean CorrectLetter = false;
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (guess.charAt(0) == wordToGuess.charAt(i)) {
                            CorrectLetter = true;
                            wordGuess.setCharAt(i, wordToGuess.charAt(i));
                        }
                    }

                    if (CorrectLetter) {
                        System.out.println("\nYou guessed the letter!");
                    } else {
                        System.out.println("\nYou did not guess the letter!");
                        lives--;
                    }

                    usedLetters.add(guess);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
            }
            if (wordGuess.toString().equals(wordToGuess)) {
                System.out.println("You won!");
                System.out.println("The word was: " + wordToGuess);
                break;
            }
            if (lives == 0) {
                System.out.println("You lost!");
                System.out.println("The word was: " + wordToGuess);
            }

        }
    }
}
