package PRJECT;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car{
    private  String  carid;
    private  String  brand;
    private  String  model;
    private double basepriceperday;
    private boolean isavailable;
    //constructor usage
    public  Car(String carid,String brand,String model,double basepriceperday, boolean isavailable){
        this.carid=carid;
        this.brand=brand;
        this.model=model;
        this.basepriceperday= basepriceperday;
        this.isavailable=true;
    }
    public String getCarid(){
        return carid;
    }
    public  String getBrand(){
        return  brand;
    }
    public  String getModel(){
        return  model;
    }
    public  double Calculateprice(int rentalDays){
        return  basepriceperday * rentalDays;
    }
    public boolean  isIsavailable(){
        return  isavailable;
    }
    public  void rent(){
        isavailable= false;
    }
    public  void  returncar(){
        isavailable= true;
    }

}
class  Customer{
    private  String CustomerId;
    private  String name;
    public  Customer ( String CustomerId, String name){
        this.CustomerId=CustomerId;
        this.name=name;

    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return name;
    }

}
class  Rental{
    private  Car car;
    private  Customer customer;
    private  int days;

    //usage of Constructor

    public  Rental( Car car, Customer customer, int days){
        this.car=car;
        this.customer = customer;
        this. days= days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}
class carRentalSystem{
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public carRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void  addCar(Car car){
        cars.add(car);
    }
    public void  addCustomer(Customer Customer){
        customers.add(Customer);
    }
    public void  rentCars( Car car , Customer customer , int days){
        if (car.isIsavailable()){
            car.rent();
            rentals.add(new Rental(car , customer , days));
        }
        else {
            System.out.println("Car is Not Available For Rent ...");
        }
    }
    public  void  returncar(Car car){
        car.returncar();
        Rental rentaltoRemove=null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentaltoRemove = rental;
                break;
            }
        }
        if (rentaltoRemove!= null){
            rentals.remove(rentaltoRemove);
            System.out.println("Car Return Successfully..");
        }
        else {
            System.out.println("Car was Not Rented");
        }

    }
    public void menu(){
        Scanner scanner= new Scanner(System.in);

        while (true){
            System.out.println("<<<<<<<<<<<<! CAR RENTAL SYSTEM !>>>>>>>>>>>>>");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit ");
            System.out.println("Enter Your Choice");

            int choice =scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                System.out.println("\n== Rent a Car ==\n");
                System.out.println("Enter Your Name");
                String customername= scanner.nextLine();


                System.out.println("\n Available Cars :  ");
                for (Car car : cars)
                {
                    if ( car.isIsavailable()){
                        System.out.println(car.getCarid() + "-" + car.getBrand() + " " + car.getModel());

                    }
                }
                System.out.print(" Enter The Car Id You want To  Rent : ");
                String carid =  scanner.nextLine();
                System.out.print("Enter The No of Days You want to Rent : ");
                int rentaldays= scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUSCArREnt" +(customers.size() + 1), customername);
                addCustomer(newCustomer);

                Car selectedCar=null;
                for(Car car : cars){
                    if (car.getCarid().equals(carid) && car.isIsavailable() ){
                        selectedCar=car;
                        break;
                    }

                }
                if (selectedCar != null){
                    double totalprice = selectedCar.Calculateprice(rentaldays);
                    System.out.println("==Rental System Information==");
                    System.out.println("Customer ID : " + newCustomer.getCustomerId());
                    System.out.println("Customer Name : " + newCustomer.getName());
                    System.out.println("Car : " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println(" Rental days : " + rentaldays);
                    System.out.println("Total Price : " + totalprice);

                    System.out.print(" Confirm  Your Rental (Y/N) :  ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCars(selectedCar , newCustomer , rentaldays);
                        System.out.println("Car Rented Successfully");
                    } else {
                        System.out.println("Rentel Cancel.");
                    }
                }else {
                    System.out.println( " Invalid Car Selection or Car is not Available for Rent");
                }
            }
            else  if (choice==2){
                System.out.println("=== Return a Car ===");
                System.out.print("Enter the Car Id to return : ");
                String carID= scanner.nextLine();

                Car returncar5=null;
                for(Car car : cars){
                    if (car.getCarid().equals(carID) && car.isIsavailable() ){
                        returncar5=car;
                        break;
                    }

                }
                if (returncar5 != null){
                    Customer customer= null;
                    for (Rental rental : rentals){
                        if ( rental.getCar() == returncar5){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null){
                        returncar(returncar5);
                        System.out.println("Car is successfully return " + customer.getName());
                    }else {
                        System.out.println("Car was not rented or rental info is missing");
                    }
                }else {
                    System.out.println("Car id not Found or rental info is missing");
                }
            } else  if (choice==3){
                break;
            } else {
                System.out.println("Invalid Choice pls enter valid Choice");
            }

        }
        System.out.println("== Thank You For using our Service ==");

    }
}


public class main {
    public static void main(String[] args) {
        carRentalSystem rentalSystem = new carRentalSystem();
        Car car1 = new Car("R-35", "NISSAN", "GT-R", 80000.0 ,true);
        Car car2 = new Car("RATATA", "Toyota", "SUPRA", 47000.0 , true);
        Car car3 = new Car("C003", "Mahindra", "Thar", 7000.0 , true);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
