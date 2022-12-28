package willcrack;
import java.util.Scanner; 

public class baconian {
    String firstFiveChars = "";	
    int z;

    public baconian(String msg) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] bacon = {"aaaaa", "aaaab", "aaaab", "aaabb", "aabaa", "aabab", "aabba", "aabbb", "abaaa", "abaab", "ababa", "ababb", "abbaa", "abbab", "abbba", "abbbb", "baaaa", "baaab", "baaba", "baabb", "babaa", "babab", "babba", "babbb", "bbaaa", "bbaab"};

        int i = 0;
        while (i < msg.length()) {
            // Check if the current character is a space
            if (msg.charAt(i) == ' ') {
                System.out.print(" ");
                i++;
                continue;
            }
            
            // Extract the next five characters as the baconian code
            firstFiveChars = msg.substring(i, i+5);
            i += 5;

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
        // System.out.println("Cipher: " + cipher);

        System.out.print("Decoded message: ");
        baconian decode = new baconian(cipher); 
        // test: aaaaaabaaa
    }
}