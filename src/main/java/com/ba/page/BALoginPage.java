package com.ba.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ba.base.BaseClass;

public class BALoginPage  extends BaseClass{
		
//	finding webelement using pagefactory--pom
//	******************page elements****************************
		@FindBy(id="LG") WebElement userId;
		@FindBy(id="PWD") WebElement userPwd;
		@FindBy(id="btnSubmit") WebElement loginBtn;
		
		
//	initializing the weblements(this) in constructor
//	**************page initialize****************************	
		public BALoginPage() {
			PageFactory.initElements(driver, this);
			
		}

//***********page methods***************
		

		public String getTitle() {
			return driver.getTitle();
		}

		public void UserId(String usrId) {
			
			userId.sendKeys(usrId);
		}
		
		public void UserPwd(String pwd) {
			userPwd.click();
			userPwd.clear();
			userPwd.sendKeys(pwd);
		}
		
		public void LoginBtn() {
			 loginBtn.click();
		}


		



		

		
		
		
}
