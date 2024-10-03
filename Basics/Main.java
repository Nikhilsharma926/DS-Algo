import java.util.Scanner;  // Import the Scanner class

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Enter the number: ");
        int a = scanner.nextInt();  // Read user input

        // Check if the number is positive or negative
        if(a > 0) {
            System.out.print("Positive");
        } else if(a < 0) {
            System.out.print("Negative");
        } else {
            System.out.print("Zero");
        }

        // Close the scanner
        scanner.close();
    }
}