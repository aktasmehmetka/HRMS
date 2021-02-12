package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class AddEmployeePage {

	/*
	 * Sprint 5
US 16767: As an admin I should be able to add an employee 

TC: Add Employee
Step 1. navigate to the application
Step 2: login into the application
Step 3: navigate to add employee page
Step 4: add employee by providing fname. mname, lname
Step 5: verify employee has been added successfully
	 */
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	public WebElement logo;
	
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id="btnLogin")
	public WebElement loginBtn;
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement AddEmpl;
	
	@FindBy(id="firstName")
	public WebElement name;
	
	@FindBy(id="lastName")
	public WebElement lname;
	
	@FindBy(id="btnSave")
	public WebElement save;
	
	@FindBy(xpath="//div[@id='profile-pic']/h1")
	public WebElement verify;
	
	public AddEmployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
