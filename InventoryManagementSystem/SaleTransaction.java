
/**
 * The SaleTransaction class will specify the attributes and behaviours of a sale transaction.
 * This class is responsible for recording products purchased and removed from the shopping cart.
 * @author (Jian Huang) 
 * @version (2018/08/14)
 */
public class SaleTransaction
{
    private int saleCode;
    private Product[] items;
    private double totalCost;

    /**
     * Constructor for objects of class SaleTransaction
     */
    public SaleTransaction()
    {
        saleCode = 0;
        items = new Product[3];
        totalCost = 0;
    }
    
    private SaleTransaction(int saleCode)
    {
        this.saleCode = saleCode;
        items = new Product[3];
        totalCost = 0;
    }

    public int getSaleCode()
    {
        return saleCode;
    }
    
    public void setSalCode(int saleCode)
    {
        this.saleCode = saleCode;
    }
    
    public Product[] getItems()
    {
        return items;
    }
    
    public void setItems(Product[] items)
    {
        this.items = items;
    }
    
    public double getTotalCost()
    {
        totalCost = 0;
        for (int i =0; i < items.length; i++)
        {
            if(items[i] != null)
            totalCost += items[i].getPrice() * items[i].getMinOrderQty();
        }
        return totalCost;
    }
    
    public void setTotalCost(double totalCost)
    {
        this.totalCost = totalCost;
    }
    
    public void displaySaleTransaction()
    {
        System.out.println("saleCode = " + saleCode);
        for (int i =0; i < items.length; i++)
        {
            items[i].displayProduct();
        }
        System.out.println("totalCost = " + totalCost);
    }
}
