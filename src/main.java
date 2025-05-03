import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Game game = new Game();
        Settings settings = new Settings();
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("-- Hangman game --");
            System.out.println("1 - Start game.");
            System.out.println("2 - Settings.");
            System.out.println("3 - Scoreboard.");
            System.out.println("4 - Exit.");

            try {
                String choiceString = input.nextLine();
                int choice = Integer.parseInt(choiceString);

                switch(choice) {
                    case 1:
                        game.start();
                        exit = true;
                        break;
                    case 2:
                        settings.menu();
                        break;
                    case 3:
                        //System.out("wip :)");
                        //exit = true;
                        break;
                    case 4:
                        System.out.println("Bye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }








        /*Random rand = new Random();
        Scanner input = new Scanner(System.in);

        String words_csv = "4000-most-common-english-words.csv";
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(words_csv))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }


        String word = words.get(rand.nextInt(words.size()));
        StringBuilder wordGuess = new StringBuilder(word);
        for(int i = 0; i < wordGuess.length(); i++) {
            wordGuess.setCharAt(i, '_');
        }

        List<String> usedLetters = new ArrayList<>();

        int lives = 10;
        while (lives > 0) {
            System.out.print("Used letters: ");
            for(int i = 0; i < usedLetters.size(); i++) {
                System.out.print(usedLetters.get(i) + ", ");
            }
            System.out.print("\n" + wordGuess.length() + " letter word: " + wordGuess);
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
                    for(int i = 0; i < word.length(); i++) {
                        if(guess.charAt(0) == word.charAt(i)) {
                            CorrectLetter = true;
                            wordGuess.setCharAt(i,word.charAt(i));
                        }
                    }

                    if(CorrectLetter) {
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
            if(wordGuess.toString().equals(word)) {
                System.out.println("You won!");
                System.out.println("The word was: " + word);
                break;
            }
            if(lives == 0) {
                System.out.println("You lost!");
                System.out.println("The word was: " + word);
            }
        }*/
    }
}