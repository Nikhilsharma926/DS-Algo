import java.util.*;

class p35{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int num;
        int fact =1;
        System.out.print("enter the +ve nummber :");
         num = sc.nextInt();
        for(int i=1; i<=num; i++){
            fact =fact*i;
            
        }
        System.out.print(fact);
    }
