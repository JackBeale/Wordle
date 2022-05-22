import Exceptions.GeneratorException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WordGenerator {

    private static final Logger logger = LogManager.getLogger(WordGenerator.class);


    public static String dailyWord() throws GeneratorException {

        String newWord;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/wordleWords.csv"))) {
            //Loop through each possible word
            List<String> list = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }

            //Generate the daily word
            Random random = new Random();
            int row = random.nextInt(list.size());
            newWord = list.get(row);
            logger.info("Today's generated word is: {}",newWord);

        } catch (IOException ioe) {
            String errorMsg = "Failed to generate today's wordle word, due to being unable to detect wordleWords.csv";
            logger.error(errorMsg);
            throw new GeneratorException(errorMsg,ioe);
        }
        return newWord;
    }
}
