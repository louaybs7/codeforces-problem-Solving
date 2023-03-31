
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word = input.next();
        int moves = 0 ;
        int last_ascii = 'a';
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i)  ;
            int m = Math.abs(ascii - last_ascii);
            if( m <= 13 ) {
                moves += m;
                last_ascii = ascii;
            }
            else {
                moves += 26 -m ;
                last_ascii=ascii;
            }
        }
        System.out.println(moves);

        }




}
