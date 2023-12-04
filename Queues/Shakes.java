public class Shakes {
   private String flavor;
   private double price;
   private int qty; 
    
   public void setFlavor(String flavor){
    this.flavor = flavor;
   }

    public String getFlavor(){
        return flavor;
   }

   public void setPrice(double price){
    this.price = price;
   }

    public double getPrice(){
        return price;
   }

   public void setQty(int qty){
    this.qty = qty;
   }

    public int getQty(){
        return qty;
   }
   
}