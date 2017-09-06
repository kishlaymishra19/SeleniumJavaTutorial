package Way2AutomationExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QueryValidation {
	static WebDriver driver;
	final static String successMsg="Thank you for contacting us. We will be in touch with you very soon";
	final static String userNameError="The First Name you entered does not appear to be valid";
	final static String emailIdError="The Email Address you entered does not appear to be valid";
	final static String cityError="The Last Name you entered does not appear to be valid.";
	final static String phoneNumberError="Invalid phone Number";
	final static String commentError="Comment too long";
	static String webPageTitle="Selenium Training,Selenium Tutorial,Automation Testing Training";
	
	@BeforeClass
	public static void setup(){
		System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/");
		//driver.get("https://demostore.x-cart.com/");	
	}
	
	@Test (priority=1)
	public static void validateTitle(){
		Assert.assertEquals(driver.getTitle(), webPageTitle);
	}
	
	@Test (priority=2)
	public static void validateValidCredentails(){
		String msg=submitQuery("ABC","abc@def.ghi","Bangalore","123456789","Ok Test");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(successMsg));
	}
	
	@Test (priority=3)
	public static void validateInvalidUserName(){
		String msg=submitQuery("1234","abc@def.ghi","Bangalore","123456789","Ok Test");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(userNameError));
	}
	
	@Test (priority=4)
	public static void validateInvalidEmailId(){
		String msg=submitQuery("ABC","aghi","Bangalore","123456789","Ok Test");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(emailIdError));
	}
	
	@Test (priority=5)
	public static void validateInvalidCity(){
		String msg=submitQuery("ABC","aghi","1234","123456789","Ok Test");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(cityError));
	}
	
	@Test (priority=6)
	public static void validateInvalidPhoneNumber(){
		String msg=submitQuery("ABC","aghi","Bangalore","abcd","Ok Test");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(phoneNumberError));
	}
	
	@Test (priority=7)
	public static void validateExtraLongComment(){
		String msg=submitQuery("ABC","aghi","Bangalore","123456789","Initially launched by ThoughtWorks by the developer Jason huggins with Selenium 1.0 version that includes component Selenium IDE & Remote Control (RC). Unlike every automation tool IDE provides a record and playback feature and is add-on to Firefox. Not much things can be achieved by Record and play hence actual Selenium tester don’t prefer using IDE much and rely mostly on the coding part which was achieved through RC. The architecture designed was injection of JavaScript on the browsers and was not fully supported on secured browsers, also the API was too small to handle complex functionalities. Due to these reasons the API got deprecated and replaced with WebDriver which is another Project started by Simon Stewart at Google in 2006. He realized all the challenges faced in RC and built a powerful API by removing the JavaScript injection from the architecture and replacing with actual browser native class communication by creating separate classes for every browser. For example: If you want to run automation tests on IE then there’s a class called InternetExplorerDriver which you should be using. Same for Chrome, Safari and Firefox the classes created were ChromeDriver, SafariDriver & FirefoxDriver. Even to support testing on Android and Iphone classes that were created was AndroidDriver and IPhoneDriver but the functionality was limited to WebBased testing only. Not only this, the WebDriver API itself is very huge and can handle many complex situations easily and later on named as Selenium 2.0 which was officially launched on July 2011.");
		driver.navigate().back();
		Assert.assertTrue(msg.contains(commentError));
	}
	
	@AfterClass
	public static void exitTest(){
		driver.close();
		driver.quit();
	}
	
	public static String submitQuery(String userName,String emailId,String city,String telephoneNumber,String comments){
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys(userName);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(emailId);
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys(city);
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("telephone")).sendKeys(telephoneNumber);
		driver.findElement(By.name("comments")).clear();
		driver.findElement(By.name("comments")).sendKeys(comments);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@type='submit']")).getAttribute(comments));
		
		String msgOut=driver.findElement(By.tagName("body")).getText();
		//System.out.println(msgOut);
		
		return msgOut;
	}

}
