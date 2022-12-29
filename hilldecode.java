package willcrack;
import java.util.Scanner; 
import java.lang.Math;

public class hilldecode {

    String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    // String[] capitalLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    


    String letterIndividual = "";
    String letterIndividual2 = "";
    int v;
    int t;
    int s;
    int det;


    public hilldecode(int a, int b, int c, int d, String plain) {

        for (int i = 0; i < plain.length(); i+=2) {
            letterIndividual = plain.substring(i, i+1);
            letterIndividual2 = plain.substring(i+1, i+2);
            s = a;
            a = d;
            d = s;
            b = -b;
            c = -c;
            det = ((a*c)-(b*d)) % 26;
            int y = 0;
            int x = 1;

            for (int j = 0; j < letters.length; j++) {
                
    
                if (letterIndividual.equals(letters[j])) {
                    v = j;
                }

                if (letterIndividual2.equals(letters[j])) {
                    t = j;
                }

                
                
            }

            while (det > 1) {
                int q = det / 26;
                int t = 26;
                int m;

         
                m = a % 26;
                a = t;
                t = y;
         
                y = x - q * y;
                x = t;
            }
         
            if (x < 0) {
                x += 26;
            }

            a = (det*a) % 26;
            b = (det*b) % 26;
            c = (det*c) % 26;
            d = (det*d) % 26;

            System.out.print(letters[(a*v+b*t) % 26]);
            System.out.print(letters[(c*v+d*t) % 26]);
        }
        
        System.out.println(""); 
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  
        // only doing 2x2 rn
        System.out.println("Key format:");
        System.out.println("|a b|");
        System.out.println("|c d|");
        System.out.print("Enter a: ");
        int a = myObj.nextInt();  

        Scanner myObj2 = new Scanner(System.in); 
        System.out.print("Enter b: ");
        int b = myObj2.nextInt(); 

        Scanner myObj3 = new Scanner(System.in); 
        System.out.print("Enter c: ");
        int c = myObj3.nextInt(); 

        Scanner myObj4 = new Scanner(System.in); 
        System.out.print("Enter d: ");
        int d = myObj4.nextInt(); 

        Scanner myObj5 = new Scanner(System.in); 
        System.out.print("Enter plaintext: ");
        String plain = myObj5.nextLine(); 

        System.out.print("Decoded: ");
        hilldecode decode = new hilldecode(a, b, c, d, plain); 
 
        // test: Kfzb gly!

    }
}