package main;

public class CustomerInformation 
{
    private String custID;
    private String custIC;
    private String custName;
    private String counterPaid;
    
    //Relation with class ItemInformation
    private ItemInformation itemInformation;
    
   //Constructor without parameter
    public CustomerInformation()
    {
        this.itemInformation = null;
        this.custID = null;
        this.custIC= null;
        this.custName = null;
        this.counterPaid = null;
    }
    
    //Normal Constructor
    public CustomerInformation(String custID, String custIC, String custName, String counterPaid, 
    		                   String itemID, String itemName, double itemPrice, String datePurchase)
    {
        this.itemInformation = new ItemInformation(itemID, itemName, itemPrice, datePurchase, custID);
        this.custID = custID;
        this.custIC = custIC;
        this.custName = custName;
        this.counterPaid = counterPaid;
    }
    
    //Accessor/ Getter
    public String getCustID()
    {
        return custID;
    }
    
    public String getCustIC()
    {
        return custIC;
    }
    
    public String getCustName()
    {
        return custName;
    }
    
    public String getCounterPaid()
    {
        return counterPaid;
    }
    
    //Item method
    public String getItemID()
    {
        return itemInformation.getItemID();
    }
    
    public String getItemName()
    {
        return itemInformation.getItemName();
    }
    
    public double getitemPrice()
    {
        return itemInformation.getitemPrice();
    }
    
    public String getDatePurchase()
    {
        return itemInformation.getDatePurchase();
        
    }
}