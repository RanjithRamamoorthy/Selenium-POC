package salesforce;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import salesforce.Navigation;
import osu.OSUPortal;

@Test
public class SalesforceSuite {

	static WebDriver driver;
	Navigation nav = new Navigation();
	LoginSF login = new LoginSF();
	OSUPortal osu = new OSUPortal();
	
	
	@BeforeMethod
	public static boolean browserSelect()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ramamoorthr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.out.println("browser opened");
		driver.manage().window().maximize();
		return (true);
	}
	@Test(dataProvider = "OSU")
	public void osutest(String NMI, String FN, String LN, String Email) throws InterruptedException
	{
		driver.get("https://qa.momentumenergy.com.au/switch");
		Assert.assertTrue(osu.osu(driver, NMI, FN, LN, Email), "OSU is successful");
	}
	/*@AfterMethod
	public void exit()
	{
		driver.quit();
	}*/
	
	@Test
	public void leadCreation() throws InterruptedException
	{
		Assert.assertTrue(login.login(driver, "ranjith.ramamoorthy@hydro.com.au.qa", "Momentum@2"), "Successful");
		nav.navigateToLead(driver);
		//nav.createNewLead(driver);
	}
	
	@DataProvider (name = "OSU")
	public Object [][] osuinput() throws Exception
	{
		Object [][] testObjArray = {{"64078025179", "Ranjith", "Ramamoorthy","ranjith.ramamoorthy@hydro.com.au"}};
        return (testObjArray);
	}
	
	
}
