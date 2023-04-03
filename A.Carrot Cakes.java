import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      int time = input.nextInt();
      int cakesPerOven = input.nextInt();
      int buildTime = input.nextInt();
      int ovenUse=0;
        if (n % cakesPerOven != 0)
           ovenUse = (n / cakesPerOven) + 1;
        else
            ovenUse = (n / cakesPerOven) ;

        if ((ovenUse*time) <= (buildTime+time))
          System.out.println("NO");
      else
          System.out.println("YES");
      
    }
}
