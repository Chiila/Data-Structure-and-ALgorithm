
public class ShoppingList {
    ShoppingListItem head;

    void addItem(String itemName, String itemDesc, double itemPrice){
         ShoppingListItem newItem = new ShoppingListItem(itemName, itemDesc, itemPrice);
          
         if(head == null){
            head = newItem;   
         }else{
            ShoppingListItem current = head;
            while(current.next != null){
                current = current.next;
            }
             current.next = newItem;
         }
    }
    void insertAfterNode(String itemName, String itemDesc, double itemPrice, String itemAfter) { 
        ShoppingListItem newItem = new ShoppingListItem(itemName, itemDesc, itemPrice);
        ShoppingListItem current = head; 

        while (current != null) { 
            if (current.itemName.equals(itemAfter)) { 
                newItem.next = current.next; 
                current.next = newItem; 
                return; 
            } 
            current = current.next; 
        } 
        System.out.println("Item named" + itemAfter + "not found in the list."); 
    } 

    void DisplayItems() {
        ShoppingListItem current = head;
        if(head == null){
            System.out.println("\nShoppingList is empty");
            return; 
        }

        System.out.println("\nSneki's List:");
        while (current != null) {
            System.out.println("Item name: " + current.itemName);
            System.out.println("Item description: " + current.itemDesc);
            System.out.printf("Item price: %.2f%n", current.itemPrice);
            System.out.println("Purchased: " + (current.purchased ? "Yes" : "No"));
            System.out.println("--------------------");
            current = current.next;
        }
        return;
    }

    void clearAllitems() {
        head = null;
        System.out.println("\nAll items removed");
        return;
    }

    void deleteItem(String itemNameToDelete) { 
        if (head == null) { 
            System.out.println("ShoppingList is empty. Cannot delete."); 
            return; 
        } 
        if (head.itemName.equals(itemNameToDelete)) { 
            head = head.next; 
            System.out.println("\nItem: "+ itemNameToDelete + " deleted");
            return;
        } 
        ShoppingListItem current = head; 
        while (current.next != null) { 
            if (current.next.itemName.equals(itemNameToDelete)) { 
                current.next = current.next.next; 
                System.out.println("\nItem: "+itemNameToDelete + " deleted");
                return; 
            } 
            current = current.next; 
        } 
        System.out.println("\nItem named '" + itemNameToDelete + "' not found in the list."); 

    } 

    void markAsPurchased(String itemNameToMark) {
        ShoppingListItem current = head;
        while (current != null) {
            if (current.itemName.equals(itemNameToMark)) {
                current.purchased = true;
                System.out.println(itemNameToMark + " marked as purchased");
                return;
            }
            current = current.next;
        }
        System.out.println("Item named " + itemNameToMark + " not found in the list.");
    }
    
}
