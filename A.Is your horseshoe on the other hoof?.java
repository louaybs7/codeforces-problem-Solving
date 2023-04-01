
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int last_input =input.nextInt();
        int counter=0;
        for (int i = 0; i < 3; i++) {
            int color = input.nextInt();
            if (color == last_input)
                counter++;

            last_input= color;
        }
        System.out.println(counter);
        }
}
