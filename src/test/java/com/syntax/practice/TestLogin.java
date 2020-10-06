package com.syntax.practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.LoginPageWebElements;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.ConfigUtility;

public class TestLogin extends BaseClass {

	@Test
	public void loginTest() {
		LoginPageWebElements login = new LoginPageWebElements();
		login.username.sendKeys(ConfigUtility.getProperty("username"));
		login.password.sendKeys(ConfigUtility.getProperty("password"));
		login.loginButton.click();
	}

	@Test (dataProvider = "data")
	public static void negativeLoginTest(String username, String password, String expErrMsg) {
		LoginPageWebElements login = new LoginPageWebElements();
		login.username.sendKeys(username);
		login.password.sendKeys(password);
		login.loginButton.click();

		String actualErrMsg = login.errMsg.getText();

		Assert.assertEquals(actualErrMsg, expErrMsg);
	}

	@DataProvider
	public Object[][] data() {
		Object[][] data = { { "Admin", "admin12", "Invalid credentials" },
				{ "Admi", "admin123", "Invalid credentials" },
				{"Admin", "", "Password cannot be empty"}};
		return data;

	}

}
