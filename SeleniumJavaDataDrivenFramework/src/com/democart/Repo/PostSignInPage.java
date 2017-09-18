package com.democart.Repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostSignInPage {
	
	@FindBy(id="email")
	private WebElement guestEmail;
	
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement continueButton;
	
	public WebElement getGuestEmail(){return guestEmail;}
	public WebElement getContinueButton(){return continueButton;}
}
