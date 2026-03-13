package com.comcast.crm.objrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createproductimgbutton;
	
	@FindBy(name="search")
	private WebElement ele2;
	

}
