import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int games = input.nextInt();
        String str = input.next();
        int danik = 0 ;
        int anton = 0 ;

        for (int i = 0; i < games; i++) {
            if (str.charAt(i) == 'D'){

                danik ++ ;}
            else
                anton ++;
        }
            if (danik<anton)
                System.out.println("Anton");
            else if (danik == anton) {

                System.out.println("Friendship");
            }
                else
                System.out.println("Danik");

    }
}
