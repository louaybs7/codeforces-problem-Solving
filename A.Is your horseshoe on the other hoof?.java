import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> colors = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            colors.add(input.nextInt()) ;
        }
        int counter= 4 - colors.size();
        System.out.println(counter);
    }
}
