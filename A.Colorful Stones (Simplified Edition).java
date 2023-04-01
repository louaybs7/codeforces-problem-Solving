import java.sql.Array;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();
        int counter =1 ;
        int j=0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(j)){
                counter++;
                j++;
            }
        }
        System.out.println(counter);

    }
}
