package willcrack;
import java.util.Scanner; 

public class baconian {
String firstFiveChars = "";	
String checkspace = "";
int z;
int t=0;

public baconian(String msg) {
    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] bacon = {"aaaaa", "aaaab", "aaaab", "aaabb", "aabaa", "aabab", "aabba", "aabbb", "abaaa", "abaab", "ababa", "ababb", "abbaa", "abbab", "abbba", "abbbb", "baaaa", "baaab", "baaba", "baabb", "babaa", "babab", "babba", "babbb", "bbaaa", "bbaab"};

    for (int n=0; n<msg.length()/5; n++) {
        
        firstFiveChars = msg.substring(0+6*n, 5+6*n);
        checkspace = msg.substring(5*n+5, 5*n+6);
        
        
        for (int j = 0; j < bacon.length; j++) {
            
            // System.out.println(checkspace);
            if (checkspace == " ") {
                        System.out.print(" ");
                        // z++;
                        // t = t++;
                    }
      
            if (firstFiveChars.equals(bacon[j])) {
                System.out.print(letters[j]); 
            }

            // if (letterIndividual.equals(capitalLetters[j])) {
            //     System.out.print(capitalLetters[Math.abs((j+3)%26)]); 
            // }

            // if (letterIndividual.equals(other[j])) {
            //     System.out.print(other[j]); 
            // }

            
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
    // can't add spaces rn

    System.out.print("Decoded message: ");
    baconian decode = new baconian(cipher); 
    // test: aaaaaabaaa

}
}
