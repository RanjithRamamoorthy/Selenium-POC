package mainpage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import mainpage.Login;
import utility.Screenshot;
import mainpage.HomePage;
import salesforce.LoginSF;
import salesforce.GlobalSearch;


@Test
public class PortalSuite {

	static WebDriver driver;
	HomePage home = new HomePage();
	Login login = new Login();
	Screenshot screen = new Screenshot();
	LoginSF loginsf = new LoginSF();
	GlobalSearch search = new GlobalSearch();	
	
	
	
	@BeforeMethod
	public static boolean browserSelect()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramamoorthr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("browser opened");
		driver.manage().window().maximize();
		return (true);
	}
	@AfterMethod
	public void exit()
	{
		driver.quit();
	}
	
	@Test(dataProvider = "portal")
	public void accessCheck(String url, String uName, String pWord) throws Exception
	{
		//invoke URL
		driver.get(url);
		//invoke login
		Assert.assertTrue(login.login(driver, uName, pWord), "Login Unsuccessful");
		//check page access
		Assert.assertTrue(home.pageAccessCheck(driver), "Access Error");
		//invoke logout
		Assert.assertTrue(login.logout(driver), "Logout Unsuccessful");
	}
	
	@Test(dataProvider = "sf")
	public void sfPortalAccountCompare (String username, String password) throws InterruptedException
	{
		//Salesforce Login 
		Assert.assertTrue(loginsf.login(driver, username, password), "Login Unsuccessful");
		//search global
		search.searchText(driver, "782886 - Lightning McQueen");
		//Selecting the searched account
		search.searchedAccountSelect(driver, "782886 - Lightning McQueen");
		//Salesforce Logout
		Assert.assertTrue(loginsf.logout(driver), "Logout Unsuccessful");
	}
	
	
	 /******************************************************
	 * @Dataproviders
	 ******************************************************/
	
	@DataProvider (name = "portal")
	public Object [][] portalinput() throws Exception
	{
		Object [][] testObjArray = {{"https://qa.momentumenergy.com.au/myaccount", "alchemy.bsi.ac1@hydro.com.au", "Alchemy1" }, {"https://qa.momentumenergy.com.au/myaccount", "alchemy.bsi.ah@hydro.com.au", "Alchemy1" }};
        return (testObjArray);
	}
	@DataProvider (name = "sf")
	public Object [][] sfinput() throws Exception
	{
		Object [][] testObjArray = {{"ranjith.ramamoorthy@hydro.com.au.qa", "Momentum@2" }};
        return (testObjArray);
	}
	
}
