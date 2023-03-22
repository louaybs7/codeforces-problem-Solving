import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ch1 = input.next();
        String ch2 = input.next();
       int r = ch1.toLowerCase().compareTo(ch2.toLowerCase());
       if (r == 0)
           System.out.println("0");
       else if (r<0) {System.out.println("-1");}
       else System.out.println("1");


    }
}
