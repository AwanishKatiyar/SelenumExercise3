package SelenumExercise3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class Question2 {
	static File file = new File("./propertiesFile/configuration.properties");
	static FileInputStream fi = null;
	static Properties prop = new Properties();
	static {
		try {
			fi = new FileInputStream(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		try {
			prop.load(fi);
		} catch (IOException el) {
			el.printStackTrace();

		}
	}
	
	
	
	// test case For Registration Page
	
	@Test
	public void testMethod() throws InterruptedException
	{
	String currentDir = System.getProperty("user.dir");
	
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", currentDir+prop.getProperty("driverPath"));   	
    WebDriver driver=new ChromeDriver();  		
    
    
    
	// Open Google
	driver.get(prop.getProperty("URL"));
    driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(25, TimeUnit. SECONDS);
	
	String firstname = prop.getProperty("FirstName");
	String lastName =  prop.getProperty("LastName");
	driver.findElement(By.id("firstName")).sendKeys(firstname);
	driver.findElement(By.id("lastName")).sendKeys(lastName);
	
	Thread.sleep(2000);
	String email =prop.getProperty("email");
	driver.findElement(By.id("userEmail")).sendKeys(email);
	
	String gender =prop.getProperty("gender");
	WebElement maleCheckBox = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", maleCheckBox);

	
	String mobileNumber = prop.getProperty("MoNumber");
	driver.findElement(By.id("userNumber")).sendKeys(mobileNumber);
	
	String dateOfBirth = "14 Oct 2021";
	WebElement DateBox = driver.findElement(By.cssSelector("input#dateOfBirthInput"));
	DateBox.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
 	DateBox.sendKeys(dateOfBirth);
	DateBox.sendKeys(Keys.ENTER);
	executor.executeScript("arguments[0].setAttribute('value', '"+dateOfBirth+"')",DateBox);

	
	String Hobbies = prop.getProperty("hobbies");
	WebElement hobbilesCheckBox = driver.findElement(By.xpath("//label[text()='"+Hobbies+"']/parent::div/child::input"));
	executor.executeScript("arguments[0].click()", hobbilesCheckBox);

	String stateName = prop.getProperty("state");
	WebElement stateDropDown = driver.findElement(By.xpath("//div[text()='Select State']"));
	executor.executeScript("arguments[0].innerHTML='"+stateName+"'", stateDropDown);  

	String cityName = prop.getProperty("city");
	WebElement cityDropDown = driver.findElement(By.xpath("//div[text()='Select City']"));
	executor.executeScript("arguments[0].innerHTML='"+cityName+"'", cityDropDown); 
	Thread.sleep(4000);
	
	WebElement submitBtn = driver.findElement(By.id("submit"));
	executor.executeScript("arguments[0].click();", submitBtn);
	Thread.sleep(4000);
	
	driver.close();


	}
}
