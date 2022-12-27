package willcrack;

import java.util.Scanner;

public class morse {

    // Morse code alphabet
    private static final String[] MORSE_CODE = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
        ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
        "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string of morse code to decode: ");
        String input = scanner.nextLine();

        String decoded = decodeMorse(input);
        System.out.println("Decoded message: " + decoded);
    }

    // Method to decode morse code
    public static String decodeMorse(String input) {
        StringBuilder sb = new StringBuilder();
        String[] words = input.split("   ");  // split input into words on triple space

        for (String word : words) {
            String[] letters = word.split(" ");  // split word into letters on single space
            for (String letter : letters) {
                // find the index of the morse code in the alphabet
                // and add the corresponding letter to the decoded message
                int index = java.util.Arrays.asList(MORSE_CODE).indexOf(letter);
                if (index != -1) {  // if the letter was found in the alphabet
                    sb.append((char) (index + 'A'));  // add the letter to the decoded message
                }
            }
            sb.append(" ");  // add a space between words
        }

        return sb.toString().trim();  // return the decoded message
    }
}