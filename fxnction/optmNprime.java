package fxnction;

public class optmNprime {
    
    public static boolean Isprime(int n){
        if (n==2){
            return true;
        }
        for(int i =2 ;i<Math.sqrt(n) ; i++){
           if (n%i==0){
            return false;
           }
        }
return true;
    }
    public static void main(String[] args) {
        System.out.println(Isprime(9));
    }
    
}

