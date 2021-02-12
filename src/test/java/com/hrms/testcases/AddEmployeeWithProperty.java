package com.hrms.testcases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class AddEmployeeWithProperty extends CommonMethods{

	Properties prop;
	@Test
	public void read() {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\practice\\NewFile.properties";
		
		try {
			FileInputStream file=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		String nameP=prop.getProperty("name");
		String lastNamep=prop.getProperty("password");
		
		System.out.println(nameP);
		System.out.println(lastNamep);
		
		DashboardPageElements dash=new DashboardPageElements();
		LoginPageElements login = new LoginPageElements();
		login.login(nameP, lastNamep);
		
		Assert.assertEquals(dash.welcome.getText(), "Welcome Admin");
		takeScreenshot("loginProperties");
	}
}
