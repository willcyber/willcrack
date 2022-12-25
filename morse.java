package willcrack;
import java.util.Scanner; 

public class morse {
String firstFiveChars = "";	

public morse(String msg) {
    
    switch (msg) {
        case ".- ":
            System.out.print("a ");
            break;
        case "-... ":
            System.out.print("b ");
            break;
    }

    System.out.println(""); 

}



public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  
    System.out.println("Enter cipher");
    System.out.print("Cipher: ");
    String cipher = myObj.nextLine();  

    System.out.print("Decoded message: ");
    morse decode = new morse(cipher); 

}
}
