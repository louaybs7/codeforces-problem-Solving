import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int c = 0 ;
        int l =0 ;
        for (int i = 0; i < word.length(); i++) {
            if (alphabet.contains(String.valueOf(word.charAt(i))))
                l++;
            else
                c++;
        }
        if (l == c) System.out.println(word.toLowerCase());
        else if (l > c) {System.out.println(word.toLowerCase());}
        else System.out.println(word.toUpperCase());
    }
}
