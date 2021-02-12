package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements2 extends CommonMethods{

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(id = "middleName")
	public WebElement middleName;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "chkLogin")
	public WebElement createLoginDetails;
	
	@FindBy(id = "user_name")
	public WebElement username;
	
	@FindBy(id = "user_password")
	public WebElement userPassword;
	
	@FindBy(id = "re_password")
	public WebElement confirmUserPassword;
	
	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(id = "employeeId")
	public WebElement empId;
}
