package basics;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basics {
	static WebDriver driver;
	
	public static void setupBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kishlay.mishra\\batch2\\workspace\\drivers\\chromedriver.exe");
		String downloadFilepath = "C:\\Users\\kishlay.mishra\\batch2\\workspace\\SeleniumWithJava\\";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions opt = new ChromeOptions();
		//HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		opt.setExperimentalOption("prefs", chromePrefs);
		opt.addArguments("--test-type");
		opt.addArguments("--disable-extensions");
		opt.addArguments("--start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		//cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(ChromeOptions.CAPABILITY, opt);
		driver = new ChromeDriver(cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	public static void downLoad(){
		driver.get("http://www.seleniumhq.org/download/");
        driver.findElement(By.linkText("32 bit Windows IE")).click();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setupBrowser();
		//downLoad();
		//fillInPreForm();
		formFillup();
		//testFrames();
		getscreenshot();
	}
	
	public static void waitForElementToBeClickable(WebElement element){
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static void fillInPreForm(){
		driver.get("http://way2automation.com/way2auto_jquery/frames-and-windows.php");
		driver.findElement(By.name("name")).sendKeys("ABCDFERD");
		driver.findElement(By.name("phone")).sendKeys("9876543210");
		driver.findElement(By.name("email")).sendKeys(getSaltString()+"@gmaty.com");
		driver.findElement(By.name("country")).sendKeys("India");
		driver.findElement(By.name("city")).sendKeys("BANGALORE");
		driver.findElements(By.xpath("//input[@name='username']")).get(1).sendKeys("qwqerty");
		driver.findElements(By.xpath("//input[@name='password']")).get(1).sendKeys("pojhgfc");
		driver.findElements(By.xpath("//input[@value='Submit']")).get(1).click();
		
	}
	
	public static void testFrames(){
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("http://way2automation.com/way2auto_jquery/frames-and-windows.php");
		int frameSize=driver.findElements(By.tagName("iframe")).size();
		System.out.println(frameSize);
		for (int i=1;i<frameSize;i++){
			driver.switchTo().frame(i);
		}
		
		//driver.switchTo().frame(frameSize-1);
		//driver.findElement(By.linkText("New Browser Tab")).click();
		
	}
	
	public static void formFillup(){
		driver.get("http://demo.guru99.com/test/upload/");
		driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\kishlay.mishra\\Desktop\\Desktop\\ship.png");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
	}
	
	public static void getscreenshot() 
    {
    	try{
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
            }
    	catch(Exception e){
    		e.printStackTrace();
    		}
    }

}
