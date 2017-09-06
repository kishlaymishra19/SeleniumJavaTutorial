package com.democart.WebElementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePage {
	@FindBy(id="page-title")
	private WebElement confirmationMsg;
	
	@FindBy(xpath="//h2[@class='invoice']")
	private WebElement invoiceNumber;
	
	@FindBy(xpath="//div[@class='total']/span[2]")
	private WebElement totalCost;
	
	public WebElement getConfirmationMsg(){return confirmationMsg;}
	public WebElement getInvoiceNumber(){return invoiceNumber;}
	public WebElement getTotalCost(){return totalCost;}
}
