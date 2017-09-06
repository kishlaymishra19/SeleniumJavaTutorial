package com.democart.WebElementRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreSignInPage {
	@FindBy(id="login-email")
	private WebElement inputLoginEmail;
	
	@FindBy(id="login-password")
	private WebElement inputLoginPassword;
	
	@FindBy(xpath="//span[text()='Sign in']")
	private List<WebElement> inputSignInBtnList;
	
	public WebElement getInputLoginEmail(){return inputLoginEmail;}
	public WebElement getInputLoginPassword(){return inputLoginPassword;}
	public List<WebElement> getInputSignInBtnList(){return inputSignInBtnList;}

}
