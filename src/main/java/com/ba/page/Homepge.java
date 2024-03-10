package com.ba.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ba.base.BaseClass;

public class Homepge extends BaseClass{
	
//	******************page elements****************************
		@FindBy(id="TopNav_lnkAA") WebElement membershipdrpdown;
		@FindBy(id="ucMemberLeft_trAddMember") WebElement addMember;
		
		
		
//	initializing the weblements(this) in constructor
//	**************page initialize****************************	
		public Homepge() {
			PageFactory.initElements(driver, this);
		}

//***********page methods***************
	public void getClick(WebElement element)	{
		element.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	

}
