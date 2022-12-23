package willcrack;
import java.util.Scanner; 
import java.lang.Math;

public class willcrack {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    


    String letterIndividual = "";


    public willcrack(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            letterIndividual = msg.substring(i, i+1);


            if (letterIndividual.equals(" ")) {
                System.out.print(" "); 
            }

            if (letterIndividual.equals("!")) {
                System.out.print("!"); 
            }

            for (int j = 0; j < letters.length; j++) {

      
                if (letterIndividual.equals(letters[j])) {
                    System.out.print(letters[Math.abs((j+3)%26)]); 
                }

                if (letterIndividual.equals(capitalLetters[j])) {
                    System.out.print(capitalLetters[Math.abs((j+3)%26)]); 
                }

                
                
                
            }
        }
        System.out.println(""); 
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        System.out.println("Enter cipher");
        String cipher = myObj.nextLine();  


        willcrack decode = new willcrack(cipher); 
        // test: Kfzb gly!

    }
}