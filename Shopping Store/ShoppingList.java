import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingList {
    private ArrayList<Item> items;
    private ArrayList<Item> purchasedItems;

    public ShoppingList(ArrayList<Item> items, ArrayList<Item> purchasedItems) {
        this.items = items;
        this.purchasedItems = purchasedItems;

        items.add(new Item("Pringles", "Chips", 75.00, 10));
        items.add(new Item("Hair Clip", "Accessories", 20.00, 10));
        items.add(new Item("Toothpaste", "Dental Care", 7.75, 10));
    }

    public void run(Scanner scanner) {
        while (true) {
        	System.out.println("WELCOME TO SEA TO SHOP");
            System.out.println();
            System.out.println("LISTS OF ITEMS:");
            int itemCount = 1;
            for (Item item : items) {
                System.out.println();
                System.out.println("[" + itemCount + "] Item Name: " + item.itemName);
                System.out.println("Item Description: " + item.itemDescription);
                System.out.printf("Price: %.2f%n", item.itemPrice);
                System.out.println("Stock: " + item.stock);
                itemCount++;
            }
            
            System.out.println("________________________________________");
            System.out.println("Home:");
            System.out.println("[1] Add an item");
            System.out.println("[2] Remove an item");
            System.out.println("[3] Buy an item");
            System.out.println("[4] Show List of items you purchased");
            System.out.println("[5] Quit");
            System.out.println("________________________________________");

            int choice;

            do {
                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numerical choice.");
                    scanner.nextLine();
                }
            } while (true);

            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("| ADDING AN ITEM |");
                        System.out.println("[1] Continue");
                        System.out.println("[2] Back to home");
                        int addItemChoice;
                        do {
                            System.out.print("Enter your choice: ");
                            if (scanner.hasNextInt()) {
                                addItemChoice = scanner.nextInt();
                                scanner.nextLine();
                                if (addItemChoice == 1 || addItemChoice == 2) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a numerical choice.");
                                scanner.nextLine();
                            }
                        } while (true);
                        if (addItemChoice == 1) {
                            System.out.print("Item Name: ");
                            String itemName = scanner.nextLine();
                            System.out.print("Item Description: ");
                            String itemDescription = scanner.nextLine();
                            double itemPrice;
                            while (true) {
                                System.out.print("Item Price (e.g., 10.99): ");
                                if (scanner.hasNextDouble()) {
                                    itemPrice = scanner.nextDouble();
                                    scanner.nextLine();
                                    int itemStock;
                                    while (true) {
                                        System.out.print("Item Stock: ");
                                        if (scanner.hasNextInt()) {
                                            itemStock = scanner.nextInt();
                                            scanner.nextLine();
                                            items.add(new Item(itemName, itemDescription, itemPrice, itemStock));
                                            System.out.println();
                                            System.out.println("Item has been added.");
                                            System.out.println();
                                            break;
                                        } else {
                                            System.out.println("Invalid stock. Please enter a numerical value.");
                                            scanner.nextLine();
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Invalid price. Please enter a numerical value.");
                                    scanner.nextLine();
                                }
                            }
                        } else if (addItemChoice == 2) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please select a valid option.");
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("| REMOVING AN ITEM |");
                        System.out.println("Select the item number to remove or enter 0 to cancel:");
                        int removeItemNumber;
                        do {
                            System.out.print("Enter your choice: ");
                            if (scanner.hasNextInt()) {
                                removeItemNumber = scanner.nextInt();
                                scanner.nextLine();
                                if (removeItemNumber >= 0 && removeItemNumber <= items.size()) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Please enter a valid item number or 0 to cancel.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a numerical choice.");
                                scanner.nextLine();
                            }
                        } while (true);
                        if (removeItemNumber == 0) {
                            break;
                        } else {
                            Item removedItem = items.remove(removeItemNumber - 1);
                            System.out.println();
                            System.out.println("Item '" + removedItem.itemName + "' has been removed.");
                            System.out.println();
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("| BUYING AN ITEM |");
                        System.out.println("Select the item number to mark as purchased or enter 0 to cancel:");
                        int purchasedItemNumber;
                        do {
                            System.out.print("Enter your choice: ");
                            if (scanner.hasNextInt()) {
                                purchasedItemNumber = scanner.nextInt();
                                scanner.nextLine();
                                if (purchasedItemNumber >= 0 && purchasedItemNumber <= items.size()) {
                                    break;
                                } else {
                                    System.out.println("Invalid choice. Please enter a valid item number or 0 to cancel.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a numerical choice.");
                                scanner.nextLine();
                            }
                        } while (true);
                        if (purchasedItemNumber == 0) {
                            break;
                        } else {
                            Item itemToPurchase = items.get(purchasedItemNumber - 1);
                            if (itemToPurchase.stock > 0) {
                                itemToPurchase.purchased = true;
                                purchasedItems.add(itemToPurchase);
                                itemToPurchase.stock--;
                                System.out.println();
                                System.out.println("Item '" + itemToPurchase.itemName + "' has been marked as purchased.");
                                System.out.println();
                            } else {
                                System.out.println("Item '" + itemToPurchase.itemName + "' is out of stock.");
                            }
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("LISTS OF ITEMS YOU PURCHASED:");
                    itemCount = 1;
                    for (Item item : purchasedItems) {
                        System.out.println();
                        System.out.println("[" + itemCount + "] Item Name: " + item.itemName);
                        System.out.println("Item Description: " + item.itemDescription);
                        System.out.printf("Price: %.2f%n", item.itemPrice);
                        System.out.println();
                        itemCount++;
                    }
                    System.out.println("No. of items you have purchased: " + purchasedItems.size());
                    System.out.println("________________________________________");
                    break;
                case 5:
                    System.out.println("Goodbye, Thank you for Shopping! Adios kaibigang Bangus.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}