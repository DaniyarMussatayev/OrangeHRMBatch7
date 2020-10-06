package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.testBase.BaseClass;

public class LoginPageWebElements extends BaseClass {
	
	@FindBy(id = "txtUsername")
	public WebElement username;
	
	@FindBy(id = "txtPassword")
	public WebElement password;
	
	@FindBy(id = "btnLogin")
	public WebElement loginButton;
	
	@FindBy(id = "spanMessage")
	public WebElement errMsg;
	
	public LoginPageWebElements() {
		PageFactory.initElements(driver, this);
	}


}
