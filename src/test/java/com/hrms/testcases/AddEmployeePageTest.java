package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePage;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageTest extends CommonMethods{

	@Test
	public void addEmployee() {
		
		AddEmployeePage add=new AddEmployeePage();
		
		sendText(add.username, "Admin");
		sendText(add.password, "Hum@nhrm123");
		click(add.loginBtn);
		
		click(add.PIM);
		click(add.AddEmpl);
		sendText(add.name, "Abbas");
		sendText(add.lname, "Yolcu");
		click(add.save);
		
		String expected="Abbas Yolcu";
		String actual=add.verify.getText();
		Assert.assertEquals(actual, expected);
	}
}
