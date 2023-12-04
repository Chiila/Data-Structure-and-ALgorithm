import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Item> purchasedItems = new ArrayList<>();
        ShoppingList shoppingList = new ShoppingList(items, purchasedItems);
        shoppingList.run(scanner);
    }
}