import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x=0;
        int groups = 0 ;
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int mag = input.nextInt();
            if (mag != x) {
                groups++;
                x=mag;
            }else x=mag;
        }
        System.out.println(groups);

    }
}
