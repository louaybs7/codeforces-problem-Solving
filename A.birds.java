import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Integer[] wires=new Integer[n];
        for(int i=0;i<n;i++){
            wires[i]=scanner.nextInt();
        }
        int times=scanner.nextInt();
        for(int i=0;i<times;i++){
            int which =(scanner.nextInt()-1);
            int position=scanner.nextInt();
            if(which!=n-1){
                wires[which+1]+=wires[which]-position;
            }
            if(which!=0){
                wires[which-1]+=position-1;
            }
            wires[which]=0;
        }
        for(int i=0;i<n;i++){
            System.out.println(wires[i]);
        }
    }
}
