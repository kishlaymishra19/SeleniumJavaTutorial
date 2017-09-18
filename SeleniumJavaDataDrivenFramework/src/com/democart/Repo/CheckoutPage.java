package com.democart.Repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

	@FindBy(name="email")
	private WebElement inputEmail;
	
	@FindBy(name="shippingAddress[firstname]")
	private WebElement inputShippingAddressFirstName;
	
	@FindBy(name="shippingAddress[lastname]")
	private WebElement inputShippingAddressLastName;
	
	@FindBy(name="shippingAddress[street]")
	private WebElement inputShippingAddressStreet;
	
	@FindBy(name="shippingAddress[city]")
	private WebElement inputShippingAddressCity;
	
	@FindBy(name="shippingAddress[country_code]")
	private WebElement inputShippingAddressCountry;
	
	@FindBy(name="shippingAddress[state_id]")
	private WebElement inputShippingAddressState;
	
	@FindBy(name="shippingAddress[zipcode]")
	private WebElement inputShippingAddressZipCode;
	
	@FindBy(name="shippingAddress[phone]")
	private WebElement inputShippingAddressPhoneNumber;
	
	@FindBy(name="billingAddress[firstname]")
	private WebElement inputBillingAddressFirstName;
	
	@FindBy(name="billingAddress[lastname]")
	private WebElement inputBillingAddressLastName;
	
	@FindBy(name="billingAddress[street]")
	private WebElement inputBillingAddressStreet;
	
	@FindBy(name="billingAddress[city]")
	private WebElement inputBillingAddressCity;
	
	@FindBy(name="billingAddress[country_code]")
	private WebElement inputBillingAddressCountry;
	
	@FindBy(name="billingAddress[state_id]")
	private WebElement inputBillingAddressState;
	
	@FindBy(name="billingAddress[zipcode]")
	private WebElement inputBillingAddressZipCode;
	
	@FindBy(name="billingAddress[phone]")
	private WebElement inputBillingAddressPhoneNumber;
	
	@FindBy(xpath="//input[@id='same_address']")
	private WebElement sameAddressCheckBox;
	
	@FindBy(xpath="//label[@title='Local pickup']/input")
	private WebElement deliveryMethodLocalPickup;
	
	@FindBy(xpath="//label[@title='Local shipping']/input")
	private WebElement deliveryMethodLocalShipping;
	
	@FindBy(xpath="//label[@title='Courier']/input")
	private WebElement deliveryMethodLocalCourier;
	
	@FindBy(xpath="//input[@id='pmethod11']")
	private WebElement pay_paypalExpressCheckout;
	
	@FindBy(xpath="//input[@id='pmethod12']")
	private WebElement pay_paypalCredit;
	
	@FindBy(xpath="//input[@id='pmethod23']")
	private WebElement pay_xPaymentsDemo;
	
	@FindBy(xpath="//input[@id='pmethod2']")
	private WebElement pay_phoneOrdering;
	
	@FindBy(id="place_order_note")
	private WebElement placeOrderNote;
	
	@FindBy(xpath="//span[contains(text(),'Place order')]/ancestor::*/button")
	private WebElement placeOrderButton;
	
	public WebElement InputEmail(){return inputEmail;}
	public WebElement InputShippingAddressFirstName(){return inputShippingAddressFirstName;}
	public WebElement InputShippingAddressLastName(){return inputShippingAddressLastName;}
	public WebElement InputShippingAddressStreet(){return inputShippingAddressStreet;}
	public WebElement InputShippingAddressCity(){return inputShippingAddressCity;}
	public WebElement InputShippingAddressCountry(){return inputShippingAddressCountry;}
	public WebElement InputShippingAddressState(){return inputShippingAddressState;}
	public WebElement InputShippingAddressZipCode(){return inputShippingAddressZipCode;}
	public WebElement InputShippingAddressPhoneNumber(){return inputShippingAddressPhoneNumber;}
	
	public WebElement InputBillingAddressFirstName(){return inputBillingAddressFirstName;}
	public WebElement InputBillingAddressLastName(){return inputBillingAddressLastName;}
	public WebElement InputBillingAddressStreet(){return inputBillingAddressStreet;}
	public WebElement InputBillingAddressCity(){return inputBillingAddressCity;}
	public WebElement InputBillingAddressCountry(){return inputBillingAddressCountry;}
	public WebElement InputBillingAddressState(){return inputBillingAddressState;}
	public WebElement InputBillingAddressZipCode(){return inputBillingAddressZipCode;}
	public WebElement InputBillingAddressPhoneNumber(){return inputBillingAddressPhoneNumber;}
	
	public WebElement getSameAddressCheckBox(){return sameAddressCheckBox;}
	public WebElement getDeliveryMethodLocalPickup(){return deliveryMethodLocalPickup;}
	public WebElement getDeliveryMethodLocalShipping(){return deliveryMethodLocalShipping;}
	public WebElement getDeliveryMethodLocalCourier(){return deliveryMethodLocalCourier;}
	public WebElement getPaypalExpressCheckout(){return pay_paypalExpressCheckout;}
	public WebElement getPaypalCredit(){return pay_paypalCredit;}
	public WebElement getXPaymentsDemo(){return pay_xPaymentsDemo;}
	public WebElement getPhoneOrdering(){return pay_phoneOrdering;}
	public WebElement getOrderComments(){return placeOrderNote;}
	public WebElement getPlaceOrderButton(){return placeOrderButton;}
	
}
