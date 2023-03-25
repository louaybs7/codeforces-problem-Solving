import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String stones = input.next();
        int counter =0 ;
        for (int i = 0; i < n-1; i++) 
        {
            if (stones.charAt(i) == stones.charAt(i+1))
                counter ++;
        }
        System.out.println(counter);
    }
}
