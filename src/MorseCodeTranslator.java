   import java.util.HashMap;
import java.util.Map;

    public class MorseCodeTranslator {
        private static final Map<String, String> morseToEnglish = new HashMap<>();
        private static final Map<String, String> englishToMorse = new HashMap<>();

        static {
            String[][] morseAlphabet = {
                    {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
                    {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
                    {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
                    {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                    {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
                    {"Z", "--.."}
            };

            for (String[] entry : morseAlphabet) {
                morseToEnglish.put(entry[1], entry[0]);
                englishToMorse.put(entry[0], entry[1]);
            }
        }

        public static String morseToEnglish(String morseCode) {
            StringBuilder result = new StringBuilder();
            String[] morseLetters = morseCode.split(" ");

            for (String morse : morseLetters) {
                if (!morseToEnglish.containsKey(morse)) {
                    throw new IllegalArgumentException("Fel: Ogiltig morsekod '" + morse + "'");
                }
                result.append(morseToEnglish.get(morse));
            }

            return result.toString();
        }

        public static String englishToMorse(String text) {
            StringBuilder result = new StringBuilder();
            text = text.toUpperCase();

            for (char letter : text.toCharArray()) {
                if (letter == ' ') {
                    result.append(" ");
                } else if (!englishToMorse.containsKey(String.valueOf(letter))) {
                    throw new IllegalArgumentException("Fel: Ogiltigt tecken '" + letter + "'");
                } else {
                    result.append(englishToMorse.get(String.valueOf(letter))).append(" ");
                }
            }

            return result.toString().trim();
        }
    }

