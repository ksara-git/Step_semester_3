import java.util.*;

interface Payment {
    void makePayment(double amount);
}

class UPI implements Payment {
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + "using UPI");
    }
}
class CreditCard implements Payment {
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card");
    }
}
class NetBanking implements Payment {
    public void makePayment(double amount) {
        System.out.println("Paid Rs." + amount + " using Net Banking");
    }
}

public class Main {
public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("1. UPI"); 
    System.out.println("2. Credit Card");
    System.out.println("3. Net Banking");

    System.out.print("Enter choice: ");
    int choice = sc.nextInt();

    System.out.print("Enter amount: "); 
    double amount = sc.nextDouble();
   
    Payment p;
     if (choice == 1) { 
        p = new UPI(); 
    } 
    else if (choice == 2) { 
        p = new CreditCard();
    }
    else if (choice == 3) {
        p = new NetBanking(); 
    } 
    else {
         System.out.println("Invalid choice"); 
         return;
         } 
         p.makePayment(amount);
}
}