package willcrack.atbash;
import java.util.Scanner; 
import java.lang.Math;

public class atbash {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] other = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", " ", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "."};
    


    String letterIndividual = "";


    public atbash(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            letterIndividual = msg.substring(i, i+1);

            for (int j = 0; j < letters.length; j++) {

      
                if (letterIndividual.equals(letters[j])) {
                    System.out.print(letters[25-j]); 
                }

                if (letterIndividual.equals(capitalLetters[j])) {
                    System.out.print(capitalLetters[25-j]); 
                }

                if (letterIndividual.equals(other[j])) {
                    System.out.print(other[j]); 
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
        atbash decode = new atbash(cipher); 
 
        // test: Kfzb gly!

    }
}