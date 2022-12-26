package willcrack;
import java.util.Scanner; 
import java.lang.Math;

public class vigenere {
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    String letterIndividual = "";
    String keyletter = "";
    int value;


    public vigenere(String msg, String key) {
        for (int i = 0; i < msg.length(); i++) {
            letterIndividual = msg.substring(i, i+1);

            // for (int k = 0; k < letters.length; k++) {

      
            //     // if (keyletter.equals(letters[k])) {
            //     //     System.out.print(letters[Math.abs((k+3)%26)]); 
            //     // }

            switch (keyletter) {
                case "a":
                    value = 0;
                    break;
                case "b":
                    value = 1;
                    break;
                case "c":
                    value = 2;
                    break;
                case "d":
                    value = 3;
                    break;
                case "e":
                    value = 4;
                    break;
                case "f":
                    value = 5;
                    break;
                case "g":
                    value = 6;
                    break;
                case "h":
                    value = 7;
                    break;
                case "i":
                    value = 8;
                    break;
                case "j":
                    value = 9;
                    break;
                case "k":
                    value = 10;
                    break;
                case "l":
                    value = 11;
                    break;
                case "m":
                    value = 12;
                    break;
                case "n":
                    value = 13;
                    break;
                case "o":
                    value = 14;
                    break;
                case "p":
                    value = 15;
                    break;
                case "q":
                    value = 16;
                    break;
                case "r":
                    value = 17;
                    break;
                case "s":
                    value = 18;
                    break;
                case "t":
                    value = 19;
                    break;
                case "u":
                    value = 20;
                    break;
                case "v":
                    value = 21;
                    break;
                case "w":
                    value = 22;
                    break;
                case "x":
                    value = 23;
                    break;
                case "y":
                    value = 24;
                    break;
                case "z":
                    value = 25;
                    break;
            }

            for (int j = 0; j < letters.length; j++) {


                // System.out.println(keyletter);

                if (letterIndividual.equals(letters[j])) {
                    System.out.print(letters[Math.abs((j+value)%26)]); 

                }

                
            }
            // }
        }
            
        System.out.println(""); 
        System.out.println(String.valueOf(key));
    }

public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  
    System.out.println("Enter cipher");
    System.out.print("Cipher: ");
    String cipher = myObj.nextLine();  

    Scanner myObj2 = new Scanner(System.in);  
    System.out.println("Enter key");
    System.out.print("Key: ");
    String key = myObj2.nextLine(); 




    System.out.print("Decoded message: ");
    vigenere decode = new vigenere(cipher, key); 
}
}