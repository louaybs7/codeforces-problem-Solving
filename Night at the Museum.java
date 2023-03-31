
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        int moves = 0 ;
        int start = 'a';
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i)  ;
            int position = Math.abs(ascii - start);
            if( position <= 13 ) {
                moves += position;
                start = ascii;
            }
            else {
                moves += 26 -position ;
                start=ascii;
            }
        }
        System.out.println(moves);
        }




}
