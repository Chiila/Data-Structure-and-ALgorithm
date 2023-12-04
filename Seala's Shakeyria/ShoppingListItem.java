class ShoppingListItem {
    String itemName;
    String itemDesc;
    double itemPrice;
    boolean purchased;

    ShoppingListItem next;

   
    public ShoppingListItem(String itemName, String itemDesc, double itemPrice) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.itemPrice = itemPrice;
        this.purchased = false; 
    }
}
