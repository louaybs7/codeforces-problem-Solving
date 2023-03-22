import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ch = input.next();
        String  alphabet="abcdefghijklmnopqrstuvwxyz" ;
        String check = "";
        int counter = 0 ;
        for (int i = 0; i < ch.length(); i++) {
            String   letter = String.valueOf(ch.charAt(i));
            if (!(check.contains(letter)) ){
                counter++;
                check = check + ch.charAt(i);
            }
        }
        if (counter % 2 == 0) System.out.println("CHAT WITH HER!");
        else
            System.out.println("IGNORE HIM!");
    }
}
