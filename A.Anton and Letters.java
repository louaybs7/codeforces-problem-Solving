import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine()  ;
        int result = 0 ;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++) {
            if (alphabet.indexOf(s.charAt(i)) != -1 ){
                alphabet= alphabet.replace(s.charAt(i),'#');
                result ++;
            }
        }
        System.out.println(result);

    }
}
