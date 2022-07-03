package main;

public class ItemInformation 
{
    private String itemID;
    private String itemName;
    private double itemPrice;
    private String datePurchase;
    private String custID;
    
    //Constructor without parameter
    public ItemInformation()
    {
        this.itemID = null;
        this.itemName = null;
        this.datePurchase = null;
        this.custID = null;
        this.itemPrice = 0;
    }
    
    //Normal Constructor
    public ItemInformation(String itemID, String itemName, double itemPrice, String datePurchase, String custID)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.datePurchase = datePurchase;
        this.custID = custID;
        this.itemPrice = itemPrice;
    }
    
    //Accessor/ Getter
    public String getItemID()
    {
        return itemID;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    
    public double getitemPrice()
    {
        return itemPrice;
    }
    
    public String getDatePurchase()
    {
        return datePurchase;
        
    }
    
    public String getCustID()
    {
        return custID;
    }
}