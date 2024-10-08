package PRJECT;

import java.util.Scanner;
class atm {
    float Balance;
    int PIN = 5556;
    public void pinCheck() {
        System.out.print("Pls Enter Your PIN : ");
        Scanner dora = new Scanner(System.in);
        int show = dora.nextInt();
        if (show == PIN) {
            menu();
        } else {
            System.out.println("PLEASE ENTER THE VALID PIN!!!!");
        }

    }

    public void menu() {
        System.out.println("Please Select Your Option");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. DEPOSIT CASH");
        System.out.println("3. WITHDRAW CASH");
        System.out.println("4. EXIT");
        Scanner dora = new Scanner(System.in);
        int oPtion = dora.nextInt();
        if (oPtion == 1) {
            checkbal();
        } else if (oPtion == 2) {
            depocash();
        } else if (oPtion == 3) {
            withdraw();
        } else if (oPtion == 4) {
            exit();
        } else {
            System.out.println("Pls Enter Valid Option");
        }

    }

    public void checkbal() {
        System.out.println("Your Balance is : " + Balance);
        menu();

    }

    public void depocash() {
        System.out.print("Enter The Amount That you want Deposit : ");
        Scanner dora = new Scanner(System.in);
        float amount = dora.nextFloat();
        Balance = Balance + amount;
        System.out.println("Money Deposit SucessFully");
        menu();
    }

    public void withdraw() {
        System.out.print("Enter the amount to Withdrawn : ");
        Scanner dora = new Scanner(System.in);
        float mani = dora.nextFloat();
        if (mani > Balance) {
            System.out.println("You Have Insufficient Amount");
        } else {
            Balance = Balance - mani;
            System.out.println("Money Is Withdrawn Successfully");
        }
        menu();
    }

    public void exit() {
        System.out.println("You Have Exited");
    }
}

public class Atmachine {
    public static void main(String[] args) {
        atm obj=new atm();
        obj.pinCheck();

    }
    }
