import Exceptions.GeneratorException;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordGeneratorUnitTest {


    /**
     * This test will assert that the generated word is in the list of valid words
     *
     * @throws GeneratorException when the list of possible words can't be traversed or found
     */
    @Test
    public void testWordIsGenerated () throws GeneratorException, IOException {
        String generatedWord = WordGenerator.dailyWord();
        List<String> expected = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/wordleWords.csv"))) {
            //Loop through each possible word
            String line = reader.readLine();
            while (line != null) {
                expected.add(line);
                line = reader.readLine();
            }
        }
        assert expected.contains(generatedWord);
    }
}
