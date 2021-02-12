package HomeWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class NewAddEmployeTest extends CommonMethods{

	@Test(dataProvider="getData")
	public void addEmployeeTest(String firstName, String lastName) {
		LoginPageElements login=new LoginPageElements();
		DashboardPageElements dash=new DashboardPageElements();
		
		login.login(Constants.USER_NAME, Constants.PASSWORD);
		dash.navigateToAddEmployee();
		dash.addEmployee(firstName, lastName);
	}
	
	@DataProvider
	public Object[][] getData(){
		return ExcelUtility.excelIntoArray(Constants.XL_DATA_FILEPATH, "AddEmp");
	}
}
