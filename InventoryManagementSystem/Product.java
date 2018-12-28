
/**
 * The Product class will specify the attributes and behaviours of a product. e.
 * 
 * @author (Jian Huang) 
 * @version (08/10/2018)
 */
public class Product
{
    // instance variables - replace the example below with your own
    private String name;
    private String desc;
    private double price;
    private int qtyOnHand;
    private int minOrderQty;

    /**
     * Constructor for objects of class Product
     */
    public Product()
    {
        // initialise instance variables
        name = "default";
        desc = "product description";
        price = 0;
        qtyOnHand = 0;
        minOrderQty = 0;
    }

    public Product(String name)
    {
        this.name = name;
        desc = "product description";
        price = 0;
        qtyOnHand = 0;
        minOrderQty = 0;
    }
    
    public String getName() 
    {
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDesc()
	{
		return desc;
	}
	
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public int getQtyOnHand()
	{
		return qtyOnHand;
	}
	
	public void setQtyOnHand(int qtyOnHand)
	{
		this.qtyOnHand = qtyOnHand;
	}
	
	public int getMinOrderQty()
	{
		return minOrderQty;
	}
	
	public void setMinOrderQty(int minOrderQty)
	{
		this.minOrderQty = minOrderQty;
	}
	
	public void displayProduct()
	{
	    System.out.println("Name: " + name);
	    System.out.println(" Description: " + desc); 
	    System.out.println(" Quantity: " + qtyOnHand);
	    System.out.println(" Price: " + price); 
		System.out.println(" Min Order Qty: " + minOrderQty);
	}
}
