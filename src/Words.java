import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Words {
    private List<String> words;
    private Random rand;

    public Words() {
        words = new ArrayList<>();
        rand = new Random();
    }

    public void wordsLoader(String filePath, int difficulty_min, int difficulty_max) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
                if (line.trim().length() < difficulty_max) {
                    if (line.trim().length() > difficulty_min) {
                        words.add(line);
                    }
                }
            }
            System.out.println("File read correctly");
        } catch (IOException e) {
            System.out.println("Error reading file" + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("Word list is empty. Please load words before starting the game.");
        }
        return words.get(rand.nextInt(words.size()));
    }
}
