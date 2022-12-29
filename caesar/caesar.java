package willcrack.caesar;
import java.util.Scanner; 
import java.lang.Math;

public class caesar {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] other = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", " ", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "."};
    


    String letterIndividual = "";


    public caesar(String msg, String eord) {

        switch (eord) {
            case "e":
                for (int i = 0; i < msg.length(); i++) {
                    letterIndividual = msg.substring(i, i+1);
        
                    for (int j = 0; j < letters.length; j++) {
        
            
                        if (letterIndividual.equals(letters[j])) {
                            System.out.print(letters[Math.abs((j-3+26)%26)]); 
                        }
        
                        if (letterIndividual.equals(capitalLetters[j])) {
                            System.out.print(capitalLetters[Math.abs((j-3+26)%26)]); 
                        }
        
                        if (letterIndividual.equals(other[j])) {
                            System.out.print(other[j]); 
                        }
        
                        
                    }
                }
                break;
            case "d":
                for (int i = 0; i < msg.length(); i++) {
                    letterIndividual = msg.substring(i, i+1);
        
                    for (int j = 0; j < letters.length; j++) {
        
            
                        if (letterIndividual.equals(letters[j])) {
                            System.out.print(letters[Math.abs((j+3)%26)]); 
                        }
        
                        if (letterIndividual.equals(capitalLetters[j])) {
                            System.out.print(capitalLetters[Math.abs((j+3)%26)]); 
                        }
        
                        if (letterIndividual.equals(other[j])) {
                            System.out.print(other[j]); 
                        }
        
                        
                    }
                }
                break;
        }

        
        System.out.println(""); 
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter cipher/plaintext");
        System.out.print("Original: ");
        String cipher = myObj.nextLine();  
        // System.out.println("Cipher: " + cipher);

        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Encryption (e) or Decryption (d)");
        System.out.print("eord: ");
        String eord = myObj2.nextLine();  

        System.out.print("Decoded/Encoded message: ");
        caesar decode = new caesar(cipher, eord); 
 
        // test: Kfzb gly!

    }
}