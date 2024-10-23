package BinarySystem;

public class decTobin {
    public static void db(int dc){
        int mynum = dc;
        int pow =0;
        int bnum = 0;
        while(dc>0){
        int rem = dc%2;
        bnum = bnum + (rem*(int)Math.pow(10, pow));
        pow++;
        dc=dc/2;

        }
        System.out.println("decimal to binary "+mynum +" ="+bnum);

    }
    public static void main(String[] args) {
        db(5);
    }
    
}
