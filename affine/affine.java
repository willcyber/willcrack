package willcrack.affine;
import java.util.Scanner; 
import java.lang.Math;

public class affine {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] other = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "?", " ", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "_", "=", "."};
    


    String letterIndividual = "";


    public affine(String msg, String eord, int shift) {
        switch (eord) {
            case "e":
                for (int i = 0; i < msg.length(); i++) {
                    letterIndividual = msg.substring(i, i+1);
        
                    for (int j = 0; j < letters.length; j++) {
        
            
                        if (letterIndividual.equals(letters[j])) {
                            System.out.print(letters[Math.abs((j-shift+26)%26)]); 
                        }
        
                        if (letterIndividual.equals(capitalLetters[j])) {
                            System.out.print(capitalLetters[Math.abs((j-shift+26)%26)]); 
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
                            System.out.print(letters[Math.abs((j+shift)%26)]); 
                        }
        
                        if (letterIndividual.equals(capitalLetters[j])) {
                            System.out.print(capitalLetters[Math.abs((j+shift)%26)]); 
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
        System.out.print("Cipher: ");
        String cipher = myObj.nextLine();  

        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Encryption (e) or Decryption (d)");
        System.out.print("eord: ");
        String eord = myObj2.nextLine(); 

        Scanner myObj3 = new Scanner(System.in);  
        System.out.println("Enter shift");
        System.out.print("Shift: ");
        int shift = myObj3.nextInt();  

        System.out.print("Decoded/encoded message: ");
        affine decode = new affine(cipher, eord, shift); 
 
        // test: Kfzb gly!

    }
}