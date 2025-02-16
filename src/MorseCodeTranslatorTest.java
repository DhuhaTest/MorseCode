import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MorseCodeTranslatorTest {

    @Test
    public void testEnglishToMorse() {
        assertEquals(".... . .---", MorseCodeTranslator.englishToMorse("HEJ"));
    }

    @Test
    public void testMorseToEnglish() {
        assertEquals("HELLOWORLD", MorseCodeTranslator.morseToEnglish(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
    }

    @Test
    public void testMorseToEnglishSpace() {
        assertEquals("HELLO WORLD", MorseCodeTranslator.morseToEnglish(".... . .-.. .-.. ---   .-- --- .-. .-.. -.."));
    }

    @Test
    public void testInvalidMorseCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeTranslator.morseToEnglish("..--");
        });
        assertEquals("Fel: Ogiltig morsekod '..--'", exception.getMessage());
    }

    @Test
    public void testInvalidCharacterEnglishToMorse() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MorseCodeTranslator.englishToMorse("HELLO123");
        });
        assertEquals("Fel: Ogiltigt tecken '1'", exception.getMessage());
    }


    @Test
    public void testLowercaseInput() {
        assertEquals(".... . .-.. .-.. ---", MorseCodeTranslator.englishToMorse("hello"));
    }
}
