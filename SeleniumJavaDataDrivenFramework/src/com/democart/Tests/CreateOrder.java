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

import com.democart.Commonlib.ConstantClass;
import com.democart.Commonlib.Drivers;
import com.democart.Commonlib.ExcelUtils;
import com.democart.Repo.*;

import org.testng.annotations.*;

public class CreateOrder {
	static ExcelUtils data=new ExcelUtils();
	static WebDriver driver;
	static HomePage hp;
	static PreSignInPage preLoginPage;
	static PostSignInPage postLoginPage;
	static SearchResultPage sr;
	static AddToCartPopupPage addToCartPopupPage;
	static CheckoutPage cp;
	static InvoicePage ip;
	static int n;
	
	@BeforeClass
	public static void setup(){
		driver=Drivers.setupChromeBrowser();
		hp=PageFactory.initElements(driver, HomePage.class);
		preLoginPage=PageFactory.initElements(driver, PreSignInPage.class);
		postLoginPage=PageFactory.initElements(driver, PostSignInPage.class);
		sr=PageFactory.initElements(driver, SearchResultPage.class);
		addToCartPopupPage=PageFactory.initElements(driver, AddToCartPopupPage.class);
		cp=PageFactory.initElements(driver, CheckoutPage.class);
		ip=PageFactory.initElements(driver, InvoicePage.class);
		
		driver.get(ConstantClass.demoCartURL);
	}
	
	@AfterClass
	public static void cleanUp(){

			driver.close();
			driver.quit();

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
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOf(element));
		System.out.println("Wait ended for loader");
		}
		catch(NoSuchElementException e){
			System.out.println("Unable to find loader");
		}
	}
	
	public static void continueAsGuest(){
		postLoginPage.getGuestEmail().sendKeys(data.getData(n, "Emailid"));
		postLoginPage.getContinueButton().click();
	}
	
	public static void login() throws InterruptedException{
		hp.getSignInButtonList().get(1).click();
		preLoginPage.getInputLoginEmail().sendKeys(data.getData(n, "UserName"));
		preLoginPage.getInputLoginPassword().sendKeys(data.getData(n, "Password"));
		preLoginPage.getInputSignInBtnList().get(1).click();
		Thread.sleep(3000);
	}
	
	public static void searchItem(){
		hp.getSearchInputBoxList().get(0).sendKeys("ok");
		hp.getSearchInputBoxList().get(0).submit();
	}
	
	public static void addToCart(){
		WebElement pi=sr.getSearchResultList().get(0);
		
		Actions act=new Actions(driver);
		act.moveToElement(pi)
		.click(sr.getAddToCart()).build().perform();
		
		addToCartPopupPage.getCheckoutBtn().click();
	}
	

	public static void checkOut() throws InterruptedException{
		cp.InputEmail().clear();
		cp.InputEmail().sendKeys(data.getData(n, "Emailid"));
		
		cp.InputShippingAddressFirstName().clear();
		cp.InputShippingAddressFirstName().sendKeys(data.getData(n, "FirstName"));
		
		cp.InputShippingAddressLastName().clear();
		cp.InputShippingAddressLastName().sendKeys(data.getData(n, "LastName"));
		
		cp.InputShippingAddressStreet().clear();
		cp.InputShippingAddressStreet().sendKeys(data.getData(n, "Address"));
		
		cp.InputShippingAddressCity().clear();
		cp.InputShippingAddressCity().sendKeys(data.getData(n, "City"));
		
		cp.InputShippingAddressCountry().sendKeys(data.getData(n, "Country"));
		cp.InputShippingAddressState().sendKeys(data.getData(n, "State"));
		
		cp.InputShippingAddressZipCode().clear();
		cp.InputShippingAddressZipCode().sendKeys(data.getData(n, "Pincode"));
		
		cp.InputShippingAddressPhoneNumber().clear();
		cp.InputShippingAddressPhoneNumber().sendKeys(data.getData(n, "PhoneNumber"));
		
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

	public static void logout() throws InterruptedException{
		driver.get(ConstantClass.demoCartURL);
		hp.getMyAccountLink().click();
		hp.getLogoutButton().click();
	}
	
	@Test(priority=1)
	public static void testOrderWithRegisteredUser() throws InterruptedException{
		n=4;
		login();
		searchItem();
		addToCart();
		checkOut();
		getOrderDetails();
		logout();
	}
	
	@Test(priority=2)
	public static void testOrderWithNewUser() throws InterruptedException{
		n=1;
		searchItem();
		addToCart();
		continueAsGuest();
		checkOut();
		getOrderDetails();
	}
}
