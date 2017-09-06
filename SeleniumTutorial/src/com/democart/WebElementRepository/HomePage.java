package com.democart.WebElementRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath="//input[@placeholder='Search items...']")
	private List<WebElement> searchInputBoxList;
	
	@FindBy(xpath="//div[@class='simple-search-box']//button")
	private List<WebElement> searchButtonList;
	
	@FindBy(xpath="//span[text()='Sign in / sign up']")
	private List<WebElement> signInButtonList;
	
	
	public List<WebElement> getSearchInputBoxList(){return searchInputBoxList;}
	public List<WebElement> getSearchButtonList(){return searchButtonList;}
	public List<WebElement> getSignInButtonList(){return signInButtonList;}

	
}
