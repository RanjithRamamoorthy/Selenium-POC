package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSF {

	By txtUserName = By.id("username");
	By txtPassWord = By.id("password");
	By btnLogin = By.id("Login");
	By btnOTP = By.id("save");
	By txtGlobalSearch = By.xpath(".//*[@id='phSearchInput']");
	By btnUserNavigation = By.xpath(".//*[@id='userNavLabel']");
	By btnLogout = By.xpath(".//*[@id='app_logout']");
	By btnLogout1 = By.xpath(".//*[@id='userNav-menuItems']/a[4]");

	By searchedAccLink = By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a");
	
	public boolean login (WebDriver driver, String username, String password) throws InterruptedException
	{
		Boolean a = false;
		
		driver.get("https://test.salesforce.com/");
		WebDriverWait wait = new WebDriverWait(driver, 2); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
		driver.findElement(txtUserName).sendKeys(username);
		driver.findElement(txtPassWord).sendKeys(password);
		driver.findElement(btnLogin).click();
		
		/*if (driver.findElements(btnOTP).size()>0)
		{
			Thread.sleep(30000);
			WebDriverWait waitOTP = new WebDriverWait(driver, 50); 
			waitOTP.until(ExpectedConditions.visibilityOfElementLocated(txtGlobalSearch));
		}
		
		if (driver.findElements(txtGlobalSearch).size()>0)
		{
			System.out.println("Salesforce login Successful");
			a = true;
		}
		else
			System.out.println("Salesforce Login Unsuccessful. Verify the username/password.");
		return a;*/
		
		return true;
	}
	
	public boolean logout (WebDriver driver)
	{
		boolean a = false;
		
		if (driver.findElements(btnUserNavigation).size()>0)
		{
			a = true;
			driver.findElement(btnUserNavigation).click();
			if (driver.findElements(btnLogout).size()>0)
				driver.findElement(btnLogout).click();
			else if (driver.findElements(btnLogout1).size()>0)
				driver.findElement(btnLogout1).click();
			System.out.println("Logout Successful");
		}
		
		else
			System.out.println("Salesforce Logout Unsuccessful");
		
		return a;
	}
	
}
