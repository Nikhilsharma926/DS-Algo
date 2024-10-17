package practicesQues;
import java.util.*;
class p32 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       do{
           System.out.print("enter any no.");
           int n = sc.nextInt();
           if(n%10==0){
               break;
           }
           System.out.println(n);
       }
       while(true);
       
    }
}