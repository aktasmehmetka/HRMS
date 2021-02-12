package HomeWork;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.AddEmployeePage;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;


public class AddEmployeeByXlsxFile extends CommonMethods{

	@Test(dataProvider = "getData")
	public void addEmployee(String name, String lastName) {
		
		LoginPageElements login = new LoginPageElements();
		AddEmployeePage addEmp=new AddEmployeePage();
		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		DashboardPageElements dash=new DashboardPageElements();
		dash.navigateToAddEmployee();
		sendText(addEmp.name, name);
		sendText(addEmp.lname, lastName);
		click(addEmp.save);
		
		Assert.assertEquals(addEmp.name.getText(), name+" "+addEmp.lname.getText(), lastName);
		takeScreenshot("addEmployeeFromXL "+name+lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.FOR_PRACTICE, "AddEmployee");
	}
	
//	@DataProvider
//	public Object[][] getDataFromXL() throws IOException{
//		
//		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\practice\\Example.xlsx";
//
//		FileInputStream fil = new FileInputStream(filePath);
//
//		Workbook wb = new XSSFWorkbook(fil);
//		Sheet sheet = wb.getSheet("Sheet2");
//		int rows=sheet.getPhysicalNumberOfRows();
//		int col=sheet.getRow(0).getLastCellNum();
//		
//		Object[][] data=new Object[rows-1][col];   
//		for (int i = 1; i < rows; i++) {
//			//looping from 1 column in excel
//			for (int y = 0; y < col; y++) {
//				//retrieve value from excel by specified row and column
//				String value = sheet.getRow(i).getCell(y).toString();
//				System.out.println(value);
//				//storing retrived data into 2D object array
//				data[i-1][y]=value;
//			}
//		}
//		return data;
//	}
}
