package fxnction;
import java.util.*;

public class argsparam {

    public static int Sumofnum(int a , int b){ ///parameters
       
        int sum = a+b;
        System.out.println("sum" +sum);
        return sum;

    }
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Sumofnum( a , b); //// args

    }
    
}
