package willcrack;
import java.util.Scanner; 
import java.lang.Math;

public class porta {
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    String letterIndividual = "";
    int value;

    public porta(String msg, String key) {
        // Iterate through the message
        for (int i = 0; i < msg.length(); i++) {
            letterIndividual = msg.substring(i, i+1);

            // Extract the corresponding key letter
            char keyLetter = key.charAt(i % key.length());

            // Find the corresponding value for the key letter
            for (int j = 0; j < letters.length; j++) {
                if (keyLetter == letters[j].charAt(0)) {
                    value = j;
                    break;
                }
            }

            // Find the corresponding letter for the message letter
            for (int j = 0; j < letters.length; j++) {
                if (letterIndividual.equals(letters[j])) {
                    if (j<13) {
                        System.out.print(letters[(int) (j+Math.floor(value/2)) %13 +13]);
                    }
                    if (j>=13) {
                        System.out.print(letters[(int) (j-Math.floor(value/2)) %13]);
                    }
                    break;
                }
            }
        }
        System.out.println(""); 
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter cipher/plaintext");
        System.out.print("Cipher/plaintext: ");
        String cipher = myObj.nextLine();  

        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Enter key");
        System.out.print("Key: ");
        String key = myObj2.nextLine(); 
        // test: olrph, momen

        System.out.print("Decoded/Encoded message: ");
        porta decode = new porta(cipher, key); 
    }
}
