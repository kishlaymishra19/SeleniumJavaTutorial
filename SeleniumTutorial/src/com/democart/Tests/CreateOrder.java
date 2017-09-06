package com.democart.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.democart.WebElementRepository.*;
import org.testng.annotations.*;
import com.democart.CommonLib.*;

public class CreateOrder {
	static WebDriver driver;
	static HomePage hp;
	static PreSignInPage loginPage;
	static SearchResultPage sr;
	static AddToCartPopupPage addToCartPopupPage;
	static CheckoutPage cp;
	static InvoicePage ip;
	
	@BeforeClass
	public static void setup(){
		driver=Drivers.setupChromeBrowser();
		hp=PageFactory.initElements(driver, HomePage.class);
		loginPage=PageFactory.initElements(driver, PreSignInPage.class);
		sr=PageFactory.initElements(driver, SearchResultPage.class);
		addToCartPopupPage=PageFactory.initElements(driver, AddToCartPopupPage.class);
		cp=PageFactory.initElements(driver, CheckoutPage.class);
		ip=PageFactory.initElements(driver, InvoicePage.class);
		
		driver.get(ConstantClass.demoCartURL);
	}
	
	@AfterClass
	public static void cleanUp(){

			/*driver.close();
			driver.quit();*/

	}
	
	public static void waitforElementToBeVisible(WebElement element){
		System.out.println("Wait started for element to be visible");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.visibilityOf(element));
		System.out.println("Wait ended for element to be visible");
	}
	
	public static void waitforElementToClickable(WebElement element){
		System.out.println("Wait started for element to be clickable");
		WebDriverWait wait=new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Wait ended for element to be clickable");
	}
	
	public static void waitForLoader(){
		try{
		WebElement element=	driver.findElement(By.cssSelector("div.wait-block-overlay"));
		System.out.println("Wait started for loader");
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(element));
		System.out.println("Wait ended for loader");
		}catch(NoSuchElementException e){
			System.out.println("Unable to find loader");
			//e.printStackTrace();
		}
	}
	
	@Test(priority=1)
	public static void login() throws InterruptedException{
		hp.getSignInButtonList().get(1).click();
		loginPage.getInputLoginEmail().sendKeys(ConstantClass.loginUserName);
		loginPage.getInputLoginPassword().sendKeys(ConstantClass.loginPassword);
		loginPage.getInputSignInBtnList().get(1).click();
		System.out.println("Clicked Sign In button");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public static void searchItem(){
		hp.getSearchInputBoxList().get(0).sendKeys("phone");
		hp.getSearchInputBoxList().get(0).submit();
	}
	
	@Test(priority=3)
	public static void addToCart(){
		WebElement pi=sr.getSearchResultList().get(0);
		
		Actions act=new Actions(driver);
		act.moveToElement(pi)
		.click(sr.getAddToCart()).build().perform();
		
		addToCartPopupPage.getCheckoutBtn().click();
	}
	
	@Test(priority=4)
	public static void CheckOut() throws InterruptedException{
		cp.InputEmail().clear();
		cp.InputEmail().sendKeys("knbrothers@tellos.xyz");
		
		cp.InputShippingAddressFirstName().clear();
		cp.InputShippingAddressFirstName().sendKeys("Kishlay");
		
		cp.InputShippingAddressLastName().clear();
		cp.InputShippingAddressLastName().sendKeys("Mishra");
		
		cp.InputShippingAddressStreet().clear();
		cp.InputShippingAddressStreet().sendKeys("1000 Main Street");
		
		cp.InputShippingAddressCity().clear();
		cp.InputShippingAddressCity().sendKeys("Bangalore");
		
		cp.InputShippingAddressCountry().sendKeys("India");
		cp.InputShippingAddressState().sendKeys("Karnatka");
		
		cp.InputShippingAddressZipCode().clear();
		cp.InputShippingAddressZipCode().sendKeys("560037");
		
		cp.InputShippingAddressPhoneNumber().clear();
		cp.InputShippingAddressPhoneNumber().sendKeys("1234567890");
		
		if(!cp.getSameAddressCheckBox().isSelected()){
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cp.getSameAddressCheckBox());
			(new Actions(driver)).moveToElement(cp.getSameAddressCheckBox()).click(cp.getSameAddressCheckBox()).build().perform();
		}
		
		cp.getDeliveryMethodLocalPickup().click();
		waitForLoader();
		cp.getXPaymentsDemo().click();
		waitForLoader();
		cp.getOrderComments().clear();
		cp.getOrderComments().sendKeys("Order Comments entered");
		cp.getPlaceOrderButton().click();
	}
	
	@Test(priority=5)
	public static void getOrderDetails(){
		waitForLoader();
		if(ip.getConfirmationMsg().getText().equals(ConstantClass.orderConfirmationMsg)){
			String invoiceNo=ip.getInvoiceNumber().getText().split("#")[1];
			String totalAmt=ip.getTotalCost().getText();
			System.out.println(" ");
			System.out.println("You successfully placed Invoice No:"+invoiceNo+" for a total mount of "+totalAmt);
			System.out.println(" ");
		}
	}
}
