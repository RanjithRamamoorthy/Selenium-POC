package mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	
	By txtUserName = By.xpath("//*[@id='loginPage:j_id24:username']");
	By txtPassWord = By.xpath("//*[@id='loginPage:j_id24:password']");
	By btnLogin = By.xpath("//*[@id='loginPage:j_id24:loginButton']");
	By btnHome = By.xpath("/html/body/div[1]/section[2]/div/div/div[2]/div[1]/a/div");
	By lblFailLogin = By.xpath("/html/body/section/div/div[1]/div[2]/div[1]/form/div[1]/div/div[3]/div[2]/label");
	By btnLogout = By.xpath("/html/body/div[1]/section[1]/div/div[1]/ul/li[2]/div[2]/a/span");
	
	public boolean login (WebDriver driver, String userName, String password) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName));
		driver.findElement(txtUserName).sendKeys(userName);
		driver.findElement(txtPassWord).sendKeys(password);
		driver.findElement(btnLogin).click();
		Thread.sleep(2000);
		if (driver.findElements(btnHome).size() > 0)
		{
			System.out.println("Login Successful");
			return (true);
		}
		else 
		{
			System.out.println("Login Unsuccessful / User does not have access to home page.");
			return(false);
		}
		
	}
	
	public boolean logout(WebDriver driver)
	{
		if (driver.findElements(btnLogout).size() > 0) 
		{
			driver.findElement(btnLogout).click();
			System.out.println("Logout Successful");
			return (true);
		}
		else
		{
			System.out.println("Logout Unsuccessful");
			return (false);
		}
			
		
		
	}

}
