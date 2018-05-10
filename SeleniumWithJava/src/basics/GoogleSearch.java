package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearch {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\kishlay.mishra\\batch2\\workspace\\drivers\\chromedriver.exe");
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-extensions");
		opt.addArguments("--start-maximized");
		opt.addArguments("disable-infobars");
		opt.addArguments("--ignore-certificate-errors");
		opt.addArguments("--test-type");
		driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		WebElement ele=driver.findElement(By.name("q"));
		ele.sendKeys("Kishlay Mishra");
		ele.sendKeys(Keys.ENTER);
		
		WebElement res=driver.findElement(By.id("resultStats"));
		String result=res.getText();
		
		System.out.println(result);
		
		driver.close();
		driver.quit();
	}

}
