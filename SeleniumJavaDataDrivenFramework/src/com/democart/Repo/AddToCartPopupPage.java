package com.democart.Repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPopupPage {

	@FindBy(xpath="//div[@id='ui-id-5']//div[@class='item-buttons']/a[2]")
	private WebElement checkoutBtn;
	
	@FindBy(xpath="//div[@id='ui-id-5']//div[@class='item-buttons']/a[1]")
	private WebElement viewCartBtn;
	
	@FindBy(xpath="//div[@id='ui-id-5']//div[@class='pp-button']/button")
	private WebElement payWithPayPalBtn;
	
	public WebElement getViewCartBtn(){return viewCartBtn;}
	public WebElement getCheckoutBtn(){return checkoutBtn;}
	public WebElement getPayWithPayPalBtn(){return payWithPayPalBtn;}
}
