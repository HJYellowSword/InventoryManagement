
/**
 * The RandomNumberGenerator class will specify the attributes and behaviours for generating a
 * random number between a set minimum and a set maximum.
 * 
 * @author (Jian Huang) 
 * @version (2018/8/14)
 */
public class RandomNumberGenerator
{
    private int minimumValue;
    private int maximumValue;

    /**
     * Constructor for objects of class RandomNumberGenerator
     */
    public RandomNumberGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }

    public RandomNumberGenerator(int minimumValue, int maximumValue) 
    {
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}
    
    public int getMinimumValue()
    {
		return minimumValue;
	}
	
	public void setMinimumValue(int minimumValue)
	{
		this.minimumValue = minimumValue;
	}
	
	public int getMaximumValue()
	{
		return maximumValue;
	}
	
	public void setMaximumValue(int maximumValue)
	{
		this.maximumValue = maximumValue;
	}
	
	public void dipayNumValue()
	{
	    System.out.println("minimumValue = " + minimumValue);
	    System.out.println("maximumValue = " + maximumValue);
	}
	
	public int generator()
	{
	    double num = minimumValue + Math.random() * (maximumValue -  minimumValue);
	    return (int) num;
	}
}
