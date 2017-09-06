package com.democart.CommonLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Drivers {
	public static WebDriver driver;
	private static int timeOut=10;
	
	public static WebDriver setupChromeBrowser(){
        System.setProperty("webdriver.chrome.driver", ConstantClass.chromePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver =new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        return driver;
	}
	public static WebDriver setupFirefoxBrowser(){
        System.setProperty("webdriver.gecko.driver", ConstantClass.firefoxPath);
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        return driver;
	}
	
	public static WebDriver setupIEBrowser(){
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability("ignoreZoomSetting", true);
        System.setProperty("webdriver.ie.driver", ConstantClass.iePath);
        driver=new InternetExplorerDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        return driver;
	}
}
