package fxnction;

public class ifNprime {
public static boolean isPrime(int n){
    boolean isPrime = true;
    for(int i = 2 ; i<=n-i; i++){
        if(n%i==0){
            break;
           
        }
    }
    return isPrime;
}



    
    public static void main(String args[]){
        System.out.println(isPrime(9));
        
    }
    
}
