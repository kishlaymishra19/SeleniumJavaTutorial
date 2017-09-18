package com.democart.Repo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
	
	@FindBy(xpath="//ul[@class='products-grid grid-list']/li")
	private List<WebElement> searchResultList;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCart;
	
	public List<WebElement> getSearchResultList(){return searchResultList;}
	public WebElement getAddToCart(){return addToCart;}
	
}
