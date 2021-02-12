package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class LoginPageTest extends CommonMethods {
	
	
	@Test(dataProvider="getData")
	public void multipleLogin(String uid, String pwd) throws InterruptedException {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard=new DashboardPageElements();
		
		
		sendText(login.username, uid );
		sendText(login.password, pwd);
		click(login.loginBtn);
		String welcomeText=dashboard.welcome.getText();
		Assert.assertTrue(welcomeText.contains(uid), "User with username "+uid+" was not able to login");
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "Login");
	}
	
	
	
//	// Test case to validate valid login
//	//@Ignore
//	@Test(groups="smoke")
//	public void login() throws InterruptedException {
//		LoginPage login = new LoginPage();
//		sendText(login.username, "Admin");
//		sendText(login.password, "Syntax@123");
//		Thread.sleep(2000);
//		click(login.loginBtn);
//	}
//
//	@Test(groups="regression")
//	public void loginWithValidCredentials() throws InterruptedException {
//
//		LoginPage login = new LoginPage();
////		sendText(login.username, "Admin");
////		sendText(login.password, "Syntax@123");
//		
//		sendText(login.username, ConfigsReader.getProperty("username"));
//		sendText(login.password, ConfigsReader.getProperty("password"));
//		click(login.loginBtn);
//		
//		
//
//		Thread.sleep(1000);
//		boolean containsUsername = driver.findElement(By.id("welcome")).getText().contains("Admin");
//		Assert.assertTrue(containsUsername, "Welcome text does not contains Username");
//		takeScreenshot("loginWithValidCredentials");
//
//	}
//
//	/*
//	 * Navigate to HRMS Enter uid leave password field blank click login verify
//	 * "Password cannot be empty" text close browser
//	 */
//
//	//@Ignore
//	 @Test(groups="regression")
//	public void negativeLogin() throws InterruptedException {
//		LoginPageElements login = new LoginPageElements();
//		Thread.sleep(2000);
//		sendText(login.username, "Admin");
//		Thread.sleep(2000);
//		click(login.loginBtn);
//		Thread.sleep(2000);
//		String expected = "Password cannot be empty";
//		Assert.assertEquals(login.errorMsg.getText(), expected);
//		Thread.sleep(5000);
//	}

}