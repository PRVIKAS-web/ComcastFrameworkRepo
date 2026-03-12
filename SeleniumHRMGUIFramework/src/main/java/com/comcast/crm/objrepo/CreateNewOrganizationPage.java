package com.comcast.crm.objrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage 
{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver=null;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="accountname")
	private WebElement orgnameedt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industryd;
	
	@FindBy(name="ship_street")
	private WebElement shippingadd;
	
	public WebElement getShippingadd() {
		return shippingadd;
	}

	

	public WebElement getOrgnameedt() {
		return orgnameedt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createorg(String orgname,String shippingaddress)
	{
		orgnameedt.sendKeys(orgname);
		shippingadd.sendKeys(shippingaddress);
		savebtn.click();
	}
	
	public void createorg(String orgname,String industry,String shippingaddress)
	{
		orgnameedt.sendKeys(orgname);
		shippingadd.sendKeys(shippingaddress);
		Select sc=new Select(industryd);
		sc.selectByVisibleText(industry);
		savebtn.click();
	}
	
	
	
	

}
