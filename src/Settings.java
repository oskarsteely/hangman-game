import java.util.Scanner;

public class Settings {
    private Words words;
    private Scanner input;
    private boolean exit;
    private boolean exit_menu;
    private String filePath;
    private String category_name;
    private int difficulty_min;
    private int difficulty_max;
    private String difficulty_name;
    private String playerNickname;
    private int lives;

    public Settings() {
        input = new Scanner(System.in);
        words = new Words();
        filePath = "4000-most-common-english-words.csv";
        category_name = "Everything";
        difficulty_min = 0;
        difficulty_max = 5;
        difficulty_name = "Normal";
        playerNickname = "Player 1";
        lives = 6;
    }

    public void apply() {
        words.wordsLoader(filePath, difficulty_min, difficulty_max);
    }

    public int getLives() {
        return lives;
    }

    public void menu() {
        exit_menu = false;
        while(!exit_menu) {
            System.out.println("-- Settings -- ");
            System.out.println("1 - Category.");
            System.out.println("2 - Difficulty.");
            System.out.println("3 - Player nickname.");
            System.out.println("4 - Revert to default.");
            System.out.println("5 - Apply and go back.");

            try {
                String choiceString = input.nextLine();
                int choice = Integer.parseInt(choiceString);

                switch(choice) {
                    case 1:
                        category();
                        break;
                    case 2:
                        difficulty();
                        break;
                    case 3:
                        playerNickname();
                        break;
                    case 4:
                        new Settings();
                        break;
                    case 5:
                        apply();
                        exit_menu = true;
                        break;
                    default:
                        System.out.println("Invalid number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private void category() {
        exit = false;
        while(!exit) {
            System.out.println("Choose category:");
            System.out.println("1 - Everything.");
            System.out.println("2 - Animals.");
            System.out.println("3 - Figures.");
            System.out.println("4 - Go back. (Leave category at '" + category_name + "'.)");

            try {
                String choiceString = input.nextLine();
                int choice = Integer.parseInt(choiceString);

                switch(choice) {
                    case 1:
                        filePath = "4000-most-common-english-words.csv";
                        category_name = "Everything";
                        exit = true;
                        break;
                    case 2:
                        filePath = "4000-most-common-english-words.csv";
                        category_name = "Animals";
                        exit = true;
                        break;
                    case 3:
                        filePath = "4000-most-common-english-words.csv";
                        category_name = "Figures";
                        exit = true;
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    private void difficulty() {
        exit = false;
        while(!exit) {
            System.out.println("Choose difficulty:");
            System.out.println("1 - Easy.");
            System.out.println("2 - Normal.");
            System.out.println("3 - Hard.");
            System.out.println("4 - Go back. (Leave difficulty at '" + difficulty_name + "'.)");

            try {
                String choiceString = input.nextLine();
                int choice = Integer.parseInt(choiceString);

                switch(choice) {
                    case 1:
                        difficulty_min = 0;
                        difficulty_max = 3;
                        difficulty_name = "Easy";
                        lives = 10;
                        exit = true;
                        break;
                    case 2:
                        difficulty_min = 0;
                        difficulty_max = 6;
                        difficulty_name = "Normal";
                        lives = 6;
                        exit = true;
                        break;
                    case 3:
                        difficulty_min = 5;
                        difficulty_max = 30;
                        difficulty_name = "Hard";
                        lives = 6;
                        exit = true;
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    public void playerNickname() {
        System.out.println("Set your custom nickname that will be shown on scoreboard.");
        System.out.print("Nickname: ");
        playerNickname = input.nextLine();
    }
}
