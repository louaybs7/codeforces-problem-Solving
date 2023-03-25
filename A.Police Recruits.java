import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int officer = 0 , crime_untreated =0;
        for (int i = 0; i < n; i++) {
            int event = input.nextInt();
            if (event < 0){
                if (officer == 0)
                crime_untreated++;
                else
                    officer--;
            }else officer += event ;
        }
        System.out.println(crime_untreated);
    }
}
