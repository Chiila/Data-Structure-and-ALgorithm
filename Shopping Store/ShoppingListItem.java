class Item {
    String itemName;
    String itemDescription;
    double itemPrice;
    int stock;
    boolean purchased;

    Item(String itemName, String itemDescription, double itemPrice, int stock) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.stock = stock;
        this.purchased = false;
    }
}