
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int  n = input.nextInt();
        int [] home = new int[n];
        int [] away = new int[n];
        for (int i = 0; i < n; i++) {
            home[i]= input.nextInt();
            away[i]= input.nextInt();
        }
        int result = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (home[i] == away[j])
                    result++;
            }
        }
        System.out.println(result);
        }
}
