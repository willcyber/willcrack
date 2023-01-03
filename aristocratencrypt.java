package willcrack;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner; 

public class aristocratencrypt {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] shuffle2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] shuffle3 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};


    String letterIndividual = "";
    

    public aristocratencrypt(String msg) {
        Collections.shuffle(Arrays.asList(shuffle2));
        Collections.shuffle(Arrays.asList(shuffle3));
        for (int i = 0; i < msg.length(); i++) {
            letterIndividual = msg.substring(i, i+1);

            // Check if letterIndividual is a lowercase letter
            int lowercaseIndex = Arrays.asList(letters).indexOf(letterIndividual);
            if (lowercaseIndex >= 0) {
                System.out.print(shuffle2[lowercaseIndex]);
            } 
            // Check if letterIndividual is a capital letter
            else {
                int capitalIndex = Arrays.asList(capitalLetters).indexOf(letterIndividual);
                if (capitalIndex >= 0) {
                System.out.print(shuffle3[capitalIndex]);
                }
                // letterIndividual is not a letter, print it out as is
                else {
                System.out.print(letterIndividual);
                }
                }
                }
                System.out.println(""); 
            }
            
            public static void main(String[] args) {
                Scanner myObj = new Scanner(System.in);  
                System.out.println("Enter plaintext");
                System.out.print("Original: ");
                String cipher = myObj.nextLine();  
                // System.out.println("Cipher: " + cipher);
            
            
                System.out.print("Encoded message: ");
                aristocratencrypt decode = new aristocratencrypt(cipher); 
            
            }
        }