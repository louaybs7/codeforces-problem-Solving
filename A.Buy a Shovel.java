
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int price = input.nextInt();
        int coin = input.nextInt();
        int total= price ;
        int result = 1;
        while (total%10 != 0 && ((total-coin)%10) != 0 ) {
            total += price;
            result++;
        }
        System.out.println(result);
        }
}
