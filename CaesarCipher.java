package willcrack;

public class CaesarCipher {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    static String message1 = "Kfzb gly!"; 
    static String message2 = "zlab zlab zlab";
    static String message3 = "prmbozxifcoxdfifpqfzbumfxifalzflrp";

    String letterIndividual = "";


    public CaesarCipher(String msg) {
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
                    System.out.print(letters[(j+3)%26]); 
                }

                if (letterIndividual.equals(capitalLetters[j])) {
                    System.out.print(capitalLetters[(j+3)%26]); 
                }
                
                
            }
        }
        System.out.println(""); 
    }

    public static void main(String[] args) {
        CaesarCipher decode = new CaesarCipher(message1); 
        CaesarCipher decode2 = new CaesarCipher(message2); 
        CaesarCipher decode3 = new CaesarCipher(message3); 

    }
}