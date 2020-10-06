package com.syntax.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.LoginPageWebElements;
import com.syntax.testBase.BaseClass;
import com.syntax.utils.ConfigUtility;
import com.syntax.utils.ExcelUtility;

public class AddMultipleEmployee extends BaseClass {

	@Test(dataProvider = "data")
	public void addEmployee(String firstname, String middleName, String lastName, String username, String password)
			throws InterruptedException {
		LoginPageWebElements login = new LoginPageWebElements();
		driver.getTitle();
		login.username.sendKeys(ConfigUtility.getProperty("username"));
		login.password.sendKeys(ConfigUtility.getProperty("password"));
		login.loginButton.click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();

		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("middlename")).sendKeys(middleName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("chkLogin")).click();
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);

		String expEmpId = driver.findElement(By.id("employeeId")).getAttribute("value");
		
		driver.findElement(By.id("btnSave")).click();

		String actEmpId=driver.findElement(By.id("personal_txtEmployeeOd")).getAttribute("value");
		
		Assert.assertEquals(actEmpId, expEmpId);
	}
	
	@DataProvider
	public Object[][] data(){
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/TestData.xlsx";

		Object[][] data = ExcelUtility.excelIntoArray(filePath, "addEmp");
		return data;
	}

}
