package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class LeaveListPageTest extends CommonMethods {

	@Test(groups = "regression")
	public void leaveLabelvalidation() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();

		test.info("Loggin into the aplication");//listener classtan geliyor
		
		sendText(login.username, "Admin");
		sendText(login.password,  "Hum@nhrm123");
		click(login.loginBtn);
		
		test.info("Navigating to the leave list");//listener classtan geliyor
		
		jsClick(dashboard.leaveLnk);
		jsClick(dashboard.leaveList);
		
		test.info("Validating leave list label");//listener classtan geliyor
		
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
		
	}

	@Test(groups = "regression")
	public void leaveLabelvalidation1() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();
		LeaveListPageElements leaveList = new LeaveListPageElements();

		login.login("Admin",  "Hum@anhrm123");
		dashboard.navigateToLeaveList();
		Assert.assertTrue(leaveList.leaveListLbl.isDisplayed(), "Label is NOT displayed");
		
	}
}
