import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int [] tab = new int[n];
        int turn = 1 ,dima =0,ser =0;
        for (int i = 0; i <n; i++) {tab[i]= input.nextInt();}
        int i = 0, j = tab.length - 1;
        while (turn <=n){
            if(turn % 2 != 0){
                if (tab[i]>=tab[j])
                {ser += tab[i];
                i++;
                turn++;}
                else
                {
                 ser +=tab[j];
                 j--;
                 turn++;
                }
            }
            else
            {
                if (tab[i]>=tab[j])
                {dima += tab[i];
                    i++;
                    turn++;}
                else
                {
                    dima += tab[j];
                    j--;
                    turn++;
                }
            }
        }
        System.out.println(ser +" "+ dima);
    }
}
