package com.ba.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ba.page.BALoginPage;

public class BALoginTestCases extends BALoginPage {

	@Test
	public void testLogin() {
		BALoginPage login = new BALoginPage();
		login.UserId("itodadmin19@intellinx.com");
		login.UserPwd("itoddev96");
		login.LoginBtn();
		String title = login.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains(" Menu"));
		login.quitDriver();

	}
	
	@Test
	public void testIsForgotPwdPresent() {
		BALoginPage login = new BALoginPage();
		boolean flag = login.forgotLinkTxt();
		Assert.assertTrue(flag);
	}

}
