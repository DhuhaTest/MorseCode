import java.util.Scanner;

public class MorseCodeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Välj översättningsmetod:");
        System.out.println("1: Engelska till morsekod");
        System.out.println("2: Morsekod till engelska");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Rensa newline

        if (choice == 1) {
            System.out.println("Skriv in text att omvandla till morsekod:");
            String text = scanner.nextLine();
            try {
                System.out.println("Morsekod: " + MorseCodeTranslator.englishToMorse(text));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (choice == 2) {
            System.out.println("Skriv in morsekod att omvandla till text (använd mellanslag mellan bokstäver):");
            String morse = scanner.nextLine();
            try {
                System.out.println("Engelsk text: " + MorseCodeTranslator.morseToEnglish(morse));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Fel: Ogiltigt val.");
        }

        scanner.close();
    }
}
