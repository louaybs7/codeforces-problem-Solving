import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        int orange, waste = 0, emp = 0;
        while (n-- > 0) {
            orange = sc.nextInt();
            if (orange <= b) {
                waste += orange;
                if (waste > d) {
                    waste = 0; // empty is empty.
                    emp++;
                }
            }
        }
        System.out.println(emp);
        sc.close();
    }
}
