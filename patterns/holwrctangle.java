package patterns;

public class holwrctangle {
    public static void hollow (int totrow ,int totcol){
       //outer loop
       for(int i = 1; i<=totrow ; i++){
    //inner columns
    for(int j = 1 ; j<=totcol ; j++){
        if(i==1||i==totrow || j ==1 ||j ==totcol ){
            System.out.print("*");
        }
        else{
            System.out.print(" ");
        }

        }
        System.err.println();
       }
       
       
    }
    public static void main(String[] args) {
      hollow(4, 50);
        
    }
    
}
