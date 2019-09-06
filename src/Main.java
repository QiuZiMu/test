import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){
            int m=in.nextInt();
            int temp=m-3;
            int[] numbers=new int[m];
            for(int j=0;j<m;j++){
                numbers[j]=in.nextInt();
            }
            Arrays.sort(numbers);
            System.out.println(numbers[temp]);
        }
    }
}