import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class WordGenerator {

    @Value("${wordle.list}")
    private String wordleList;

    private static final Logger logger = LogManager.getLogger(WordGenerator.class);


    public String dailyWord() {
        String newWord = null;
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(wordleList))) {
            while (reader.readLine() != null) lines++;
        } catch ( IOException e) {
            logger.error("Failed to generate today's wordle word, due to being unable to detect wordleWords.csv");
        }

        Random rand = new Random();
        int randomNum = rand.nextInt(lines+1);


        return newWord;
    }
}
