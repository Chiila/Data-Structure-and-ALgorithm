import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ReceiptQueue {
   private Deque<Shakes> queue = new ArrayDeque<>();

   Scanner sc = new Scanner(System.in);

   public void addItem(Shakes shakes) {
    queue.add(shakes);
  }

  public void buyShake() {
    while (true) {
        try {
        	Shakes shakes = new Shakes();

            System.out.print("Enter Shake Flavor: ");
            shakes.setFlavor(sc.next());
        
            System.out.print("Enter Shake Price: ");
            shakes.setPrice(sc.nextDouble());
        
            System.out.print("Enter Shake Quantity: ");
            shakes.setQty(sc.nextInt());
        
            addItem(shakes);
        
            System.out.println("Do you want to buy again?");
            System.out.println("[1] YES");
            System.out.println("[2] NO");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 2) {
                BuyHere.Start();
                break;
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Input error: Please enter a valid number.");
            sc.nextLine();
        }
            
        }
    }    
        

    public void displayShake() {
        System.out.println("Shake in Queue: \n");
        for (Shakes shakes : queue) {
            System.out.println("Flavor: " + shakes.getFlavor());
            System.out.printf("Price: %.2f%n",  shakes.getPrice());
            System.out.println("Quantity: " + shakes.getQty());
            System.out.println();
        }
       
        while(true){
            try {
            System.out.println("[1] EXIT");
            int choice = sc.nextInt();
            sc.nextLine(); 
        
            if (choice == 1) {
                BuyHere.Start();
                break;
            }else{
                System.out.println("Input error: That's not in the choices!");
            }
            
      } catch (java.util.InputMismatchException e) {
                System.out.println("Input error: Please enter a valid number.");
                sc.nextLine(); 
        }
      }
     
        
    }

   public void printReciept(){
    System.out.println("------------ Seala's Shakeyria Receipt -------------");
    double total = 0.0;
     
      for(Shakes shakes : queue){ 
        String flavor = shakes.getFlavor();
        double price = shakes.getPrice();
        int qty = shakes.getQty();
        double subtotal = price * qty;

        System.out.println("Flavor: " + flavor);
        System.out.printf("Price: %.2f%n",  price);
        System.out.println("Quantity: " + qty);
        System.out.println();

        total += subtotal;
      }

        System.out.println("--------------------------------------------------");
        System.out.printf("Total: %.2f%n", total);
        System.out.println("--------------------------------------------------");
   }
}