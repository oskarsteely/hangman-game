import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Words {
    private Settings settings = new Settings();
    private List<String> words;
    private Random rand;

    public Words(String filePath, int difficulty_min, int difficulty_max) {
        words = new ArrayList<>();
        rand = new Random();
        wordsLoader(filePath, difficulty_min, difficulty_max);
    }

    private void wordsLoader(String filePath, int difficulty_min, int difficulty_max) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
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
        return words.get(rand.nextInt(words.size()));
    }
}
