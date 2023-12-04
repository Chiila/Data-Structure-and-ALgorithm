import java.util.Scanner;

public class BuyHere {
    private static ReceiptQueue queue = new ReceiptQueue();
    
    public static void main(String[] args) throws Exception {
        System.out.println("______________| Welcome to Seala's Shakeyria |______________");
        Start();
    }

    static void Start() {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;
        
        while (!validInput) {
            System.out.println("What do you want to do?");
            System.out.println("[1] BUY SHAKE");
            System.out.println("[2] DISPLAY THE SHAKE YOU BOUGHT");
            System.out.println("[3] CHECKOUT");
            System.out.println("[4] EXIT");
            
            try {
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        queue.buyShake();
                        break;

                    case 2:
                        queue.displayShake();
                        break;

                    case 3:
                        queue.printReciept();
                        break;

                    case 4:
                        System.out.print("______________Thank you, Come Again! :)______________");
                        return; 

                    default:
                        System.out.println("Input error: This is not in the choices");
                }
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input error: Please enter a valid number.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
