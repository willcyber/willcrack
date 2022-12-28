package willcrack;
import java.util.Scanner; 

public class binary {
    String firstFiveChars = "";	
    int z;

    public binary(String msg) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] bacon = {"1100001", "1100010", "1100011", "1100100", "1100101", "1100110", "1100111", "1101000", "1101001", "1101010", "1101011", "1101100", "1101101", "1101110", "1101111", "1110000", "1110001", "1110010", "1110011", "1110100", "1110101", "1110110", "1110111", "1111000", "1111001", "1111010"};

        int i = 0;
        while (i < msg.length()) {
            // Check if the current character is a space
            if (msg.charAt(i) == ' ') {
                System.out.print(" ");
                i++;
                continue;
            }
            
            // Extract the next five characters as the baconian code
            firstFiveChars = msg.substring(i, i+7);
            i += 7;

            // Find the corresponding letter for the baconian code
            for (int j = 0; j < bacon.length; j++) {
                if (firstFiveChars.equals(bacon[j])) {
                    System.out.print(letters[j]);
                }
            }
        }
        System.out.println(""); 
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter cipher");
        System.out.print("Cipher: ");
        String cipher = myObj.nextLine();  

        System.out.print("Decoded message: ");
        binary decode = new binary(cipher); 
        // test: 11000101100010 1100001 
    }
}