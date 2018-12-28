
/**
 * The Sale class will be the main control class of the program and will specify the attributes and
 * behaviours of the system.
 * 
 * @author (Jian Hunag) 
 * @version (2018/8/14)
 */

import java.util.Scanner;
public class Sale
{
    private ProductList prodList;
    private SaleTransaction transaction;

    /**
     * Constructor for objects of class Sale
     */
    public Sale()
    {
        prodList = new ProductList(5);
        transaction = new SaleTransaction();
    }

   private ProductList getProdList()
   {
       return prodList;
   }
   
   private void setProdList(ProductList prodList)
   {
       this.prodList = prodList;
   }
   
   private SaleTransaction getTransaction()
   {
       return transaction;
   }
    
   private void setTransaction(SaleTransaction transaction)
   {
       this.transaction = transaction;
   }
   
   public void startSystem()
   {
       System.out.print('\u000C');
       System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
       System.out.println("Welcome to the simple Inventory Management System");
       System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
       
       Scanner console = new Scanner(System.in);
       Product[] listofPro = prodList.getProductList();
       Product[] items = transaction.getItems();
       boolean flag = true;
       while(flag)
       {
           displayOption();
           String optionNum = input(console,"Please Enter your Choice: ").trim();
           switch(optionNum)
           {
               case "1":
                    System.out.print('\u000C');
                    if(listofPro[listofPro.length-1] != null)
                    {
                        System.out.print('\u000C');
                        System.out.println("You cannot register any more products!");
                    }
                    else
                    {
                        System.out.println("Register a New Product");
                        int qtyOnHand = new RandomNumberGenerator(0, 10).generator();
                        int minOrderNum = new RandomNumberGenerator(1, 5).generator();
                        prodList.registerProduct(console, qtyOnHand, minOrderNum);
                    }
                   
               break;
               
               case "2":
                    System.out.print('\u000C');
                    if(items[items.length-1] != null)
                    {
                        System.out.println("You cannot purchase any more products!");
                        continue;
                    }
                    
                    if(listofPro[0] == null)
                    {   System.out.print('\u000C');
                        System.out.println("There is no registered product, Please register first!!!");
                    }
                    else
                    {
                        System.out.println("Plaese select from the following products which are available:");
                        int count = 0;
                        for(int i = 0; i < listofPro.length; i++)
                        {
                            if(listofPro[i] != null)
                            {
                                System.out.println("Select Product " + (i+1));
                                listofPro[i].displayProduct();
                                System.out.println();
                                count++;
                            }
                        }
                        System.out.println("Select Product " + (count + 1) + " to exit purchase menu");
                        buyProducts(console, count, listofPro, items);
                    }
                  
               break;
               
               case "3":
                    System.out.print('\u000C');
                    if(items[0] == null)
                    {
                        System.out.print('\u000C');
                        System.out.println("You cart is empty!!");
                    }  
                    else
                    {
                        System.out.println("Please select from the following products from shopping cart");
                        int count = 0;
                        for(int i = 0; i < items.length; i++)
                        {
                            if(items[i] != null)
                            {
                                System.out.println("Select Added Item " + (i+1));
                                items[i].displayProduct();
                                System.out.println();
                                count++;
                            }
                        }
                        System.out.println("Select Added Item " + (count + 1) + " to exit remove menu"); 
                        removeProduct(console, count, items);
                    }
                
               break;
               
               case "4":
                    System.out.print('\u000C');
                    boolean isAvailable = false;
                    int avilableProdNum = 0;
                    for(int i = 0; i < listofPro.length; i++)
                    {
                        if(listofPro[i] != null && listofPro[i].getQtyOnHand() >= listofPro[i].getMinOrderQty())
                        {
                            isAvailable = true;
                            System.out.println("Available Product " + ++avilableProdNum);
                            listofPro[i].displayProduct();
                            System.out.println();
                        }
                    }
                    
                    if(listofPro[0] == null || !isAvailable)
                    {
                        System.out.print('\u000C');
                        System.out.println("No available registered product for now!");
                    }
                        
               break;
               
               case "5":
                    System.out.print('\u000C');
                    if(items[0] == null)
                    {
                        System.out.print('\u000C');
                        System.out.println("The Cart is Empty!!");
                    }  
                    else
                    {
                        for(int i = 0; i < items.length; i++)
                        {
                            for(int j = 0; j < listofPro.length; j++)
                            {
                                if(items[i] != null && listofPro[j] != null && items[i].getName().equals(listofPro[j].getName()))
                                {
                                    int qtyOnHand = listofPro[j].getQtyOnHand();
                                    int minOrderQty = listofPro[j].getMinOrderQty(); 
                                    if(qtyOnHand >= minOrderQty)
                                        listofPro[j].setQtyOnHand(qtyOnHand - minOrderQty);
                                    else
                                    {
                                        System.out.println("The " + items[i].getName() + " you purchased has been cancelled as quantity on hand is less than order quantity");
                                        items[i] = null;
                                    }   
                                }    
                            }
                        }
                        System.out.println("The total price of items you purchased is " + transaction.getTotalCost());
                        for(int n = 0; n < items.length; n++)
                        {
                            if(items[n] != null)
                            items[n] = null;
                        }
                        System.out.println("Thanks for shopping!");
                    }
                 
               break;
               
               case "6":
                    System.out.print('\u000C');
                    helpPage();
                    boolean isQuit = false;
                    while(!isQuit)
                    {
                        String str = input(console, "Enter q to exit Help Page: ").trim();
                        if("q".equals(str))
                        {
                            System.out.print('\u000C');
                            isQuit = true; 
                        } 
                    }
                    
               break;
               case "7":
                    System.out.print('\u000C');
                    System.out.print("Exit successfully!");
                    flag = false;
               break;
               default:
                    System.out.print('\u000C');
                    System.out.println("Please enter valid option number!");
               break;
            }
        }
       
   }
   
   private void displayOption()
   {
       System.out.println();
       System.out.println("Please Select from the following options:");
       System.out.println("Press 1 to Register a product for Sale");
       System.out.println("Press 2 to Buy a Produc to the cart");
       System.out.println("Press 3 to Remove a Product from the Cart");
       System.out.println("Press 4 to View all Available Products");
       System.out.println("Press 5 to Check out");
       System.out.println("Press 6 to Get Help");
       System.out.println("Press 7 to Exit");
       System.out.println();
       
   }
   
   private String input(Scanner console, String msg)
   {
       System.out.println(msg);
       return console.nextLine();
   }
  
   private void buyProducts(Scanner console, int count, Product[] listofPro,  Product[] items)
   {
       boolean isPurchase = true;
       while(isPurchase)
       {
           String productNoStr = input(console, "Please Enter Selected Product: ").trim();
           int productNo = 0;
           
           if(dataTypeValidation(productNoStr))
               productNo = Integer.parseInt(productNoStr);
           else
           {
               System.out.println("You must enter a valid number!");
               continue;
           }
          
           if(numValidation(productNo,count))
           {
               System.out.println("You must enter a valid number between 1 and " + (count + 1) +"!");
               continue;
           }
           
           if(productNo == count + 1)
           {
               System.out.print('\u000C');
               System.out.println("Exit Purchase Menu Successfully");
               isPurchase = false;
           }
           else
           {
               if(listofPro[productNo-1] != null && listofPro[productNo-1].getQtyOnHand() >= listofPro[productNo-1].getMinOrderQty())
               {
                   if(items[items.length-1] != null)
                   {
                        System.out.println("You cannot purchase any more products!");
                        continue;
                   }

                   for(int i = 0; i < items.length; i++)
                   {
                        if(items[i] == null)
                        {
                            items[i] = listofPro[productNo-1];
                            System.out.println("The product has been added into the cart!");
                            transaction.setSalCode(new RandomNumberGenerator(1000, 9999).generator());
                            transaction.setTotalCost(transaction.getTotalCost());
                            i = items.length;
                        }
                   }
               }
               else
               {
                  System.out.println("The product you selected is not available!");
               }
           }
       }
   }
   
   private void removeProduct(Scanner console, int count, Product[] items)
   {
       boolean isRemove = true;
       while(isRemove)
       {
           String itemNoStr = input(console, "Please Enter Added item: ").trim();
           int itemNo = 0;
           
           if(dataTypeValidation(itemNoStr))
               itemNo = Integer.parseInt(itemNoStr);
           else
           {
               System.out.println("You must enter a valid number!");
               continue;
           }           
           
           if(numValidation(itemNo,count))
           {
               System.out.println("You must enter a valid number between 1 and " + (count + 1) +"!");
               continue;
           }
           
           if(itemNo == count + 1)
           {
               System.out.print('\u000C');
               System.out.println("Exit Remove Menu Successfully");
               isRemove = false;
           }
           else
           {
               for(int i = itemNo -1; i < items.length-1; i++)
                   items[i] = items[i+1];
               items[items.length-1] = null;
               System.out.println("Remove Successfully!");
               transaction.setTotalCost(transaction.getTotalCost());
           }
       }
   }
   
   // return wheather the option number is valid
   private boolean numValidation(int num, int count)
   {
       return num <= 0 || num > count + 1;
   }
   // return wheather the input value is a integar
   private boolean dataTypeValidation(String input)
   {
       try
       {
           Integer.parseInt(input);
           return true;
       }
       catch (NumberFormatException e)
       {
           return false;
       }
   }
   
   private void helpPage()
   {
       System.out.println();
       System.out.println("Below are Help Info:");
       System.out.println("Option 1 allows you to ......");
       System.out.println("Option 2 allows you to ......");
       System.out.println("Option 3 allows you to ......");
       System.out.println("Option 4 allows you to ......");
       System.out.println("Option 5 allows you to ......");
       System.out.println("Option 6 allows you to ......");
       System.out.println("Option 7 allows you to ......");
       System.out.println();
   }
}
