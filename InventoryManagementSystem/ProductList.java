
/**
 * The ProductList class will store an array of product objects which are available to be purchased.
 * 
 * @author (Jian Huang) 
 * @version (2018/08/14)
 */
import java.util.Scanner;
public class ProductList
{
    private Product[] listOfProducts;

    /**
     * Constructor for objects of class ProductList
     */
    public ProductList()
    {
        listOfProducts = new Product[5];
    }
    
    public ProductList(int productNum)
    {
        listOfProducts = new Product[productNum];
    }

    public Product[] getProductList()
    {
        return listOfProducts;
    }
    
    public void setSingleProduct(Product product,int productNum)
    {
        listOfProducts[productNum] = product;
    }
    
    public void registerProduct(Scanner console, int qtyOnHand, int minOrderNum)
    {
        Product product = new Product();
        boolean isValidName = false;
        while (!isValidName)
        {
            String name = input(console, "Please enter the product name").trim();
            if (productNameValidation(name))
            {
                product.setName(name);
                isValidName = true;
            }
        }
        boolean isValidDes = false;
        while (!isValidDes)
        {
            String desc = input(console, "Please enter the product description:");
            if (desc.length() >= 1 && desc.length() <= 50)
            {
                product.setDesc(desc);
                isValidDes = true;
            } 
            else
                System.out.println("Must be between 1 and 50 characters long!");
        }
        boolean isValidPrice = false;
        while (!isValidPrice)
        {
            String priceStr = input(console, "Please enter the product price:").trim();
            double price = 0;
            try
            {
                price = Double.parseDouble(priceStr);
            } catch (NumberFormatException e)
            {
                System.out.println("You must enter a valid number!");
                continue;
            }
            if (price > 0) 
            {
                product.setPrice(price);
                isValidPrice = true;
            }
            else
                System.out.println("Price must be larger than 0!");
        }

        product.setQtyOnHand(qtyOnHand);
        product.setMinOrderQty(minOrderNum);
        
        for(int i = 0; i < listOfProducts.length; i++)
        {
             if(listOfProducts[i] == null)
             {
                 listOfProducts[i] = product;
                 System.out.print('\u000C');
                 System.out.println("Register successfully!");
                 i = listOfProducts.length;
             }              
        }
                      
     }
    
    private boolean productNameValidation(String name)
    {
       if(name.length() >= 3 && name.length() <= 25)
       {
           for(int i = 0; i < listOfProducts.length; i++)
           {
               if(listOfProducts[i] != null)
               {
                   int num = listOfProducts[i].getName().compareToIgnoreCase(name);
                   if(num != 0)
                        return true;
                   else
                   {
                       System.out.println("You have regeristered this product,please enter a new product name!");
                       return false;
                    }
               }
               else
                   return true;        
           }
       }
       else
       {
           System.out.println("Product Name Must be between 3 and 25 characters long!!!");
           return false;
       }
      
       return false; 
    } 
     
    private String input(Scanner console, String msg)
    {
       System.out.println(msg);
       return console.nextLine();
    } 
    
    public void displayProductList()
    {
        for (int i = 0; i < listOfProducts.length; i++ )
        {
            System.out.println("Product No."+(i+1));
            listOfProducts[i].displayProduct();
        }
    }
}
