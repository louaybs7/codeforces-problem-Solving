import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int s1 = input.nextInt();
        int s2 = input.nextInt();
        int s3 = input.nextInt();
        int s4 = input.nextInt();
        String game = input.next();
        int calories =0 ;
        for (int i = 0; i < game.length(); i++) {
            switch (game.charAt(i)){
                case '1':
                    calories += s1 ;
                    break;
 
                case '2':
                    calories += s2 ;
                    break;
 
                case '3':
                    calories += s3 ;
                    break;
                case '4':
                    calories += s4 ;
                    break;
            }
 
        }
        System.out.println(calories);
 
    }
}
