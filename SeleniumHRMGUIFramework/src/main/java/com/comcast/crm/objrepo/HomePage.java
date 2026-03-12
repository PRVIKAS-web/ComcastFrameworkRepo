package com.comcast.crm.objrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=null;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;

	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimag;
	
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	public void navigateToCampaginPage()
	{
		Actions act=new Actions(driver);
		
		act.moveToElement(moreLink).perform();
		campaignsLink.click();
		
	}
	public void logout()
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(adminimag).perform();
    	signoutlink.click();
    }
	

}
