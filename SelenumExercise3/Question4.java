package SelenumExercise3;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Question4 {
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is before Suite calling."); 
        System.out.println("\n");
		
	}
	
	
    @BeforeTest
    public void beforeTestDemo()
    {       
        System.out.println("This is before test calling."); 
        System.out.println("\n");
    }
    
    @BeforeClass
    public void beforeClassDemo()
    {
        System.out.println("This is before class calling.");
        System.out.println("\n");
    }

    @BeforeMethod
    public void beforeMethodDemo()
    {
        System.out.println("This is before method calling.");
    }
    
    
    @Test 
    public void testADemo()
    {
        System.out.println("This is Test1 calling.");
    }

    @Test
    public void testBDemo()
    {
        System.out.println("This is Test2 calling.");
    }

    @Test
    public void testCDemo()
    {
        System.out.println("This is Test3 calling.");
    }
    
    @AfterMethod
    public void afterMethodDemo()
    {
        System.out.println("This is after method calling.");
        System.out.println("\n");
    }
    
    @AfterClass
    public void afterClassDemo()
    {
        System.out.println("This is after class calling.");
        System.out.println("\n");
    }
    
    @AfterTest
    public void afterTestDemo()
    {
        System.out.println("This is after test calling.");
        System.out.println("\n");
    }
    
    @AfterSuite
	public void afterSuite()
	{
		System.out.println("This is After Suite calling."); 
        System.out.println("\n");
		
	}

}
