package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods{


	@FindBy(linkText = "Leave")
	public WebElement leaveLnk;

	@FindBy(linkText = "Leave List")
	public WebElement leaveList;

	@FindBy(linkText = "PIM")
	public WebElement pim;
	
	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;
	
	@FindBy(id="welcome")
	public WebElement welcome;
	
	@FindBy(id="firstName")
	public WebElement name;
	
	@FindBy(id="lastName")
	public WebElement lname;
	
	@FindBy(id="btnSave")
	public WebElement save;

	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void navigateToLeaveList() {
		jsClick(leaveLnk);
		jsClick(leaveList);
	}
	
	public void navigateToAddEmployee() {
		jsClick(pim);
		jsClick(addEmp);
	}
	public void addEmployee(String firstName, String lastName) {
		sendText(name, firstName);
		sendText(lname, lastName);
		click(save);
	}
}
