package mainpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.Screenshot;

public class HomePage {
	
	By linkHome = By.className("home-icon");
	By linkMyAccount = By.xpath("//a[text()='My Account']");
	By linkMyPlans = By.xpath("//a[text()='My Plans']");
	By linkMyBills = By.xpath("//a[text()='My Bills']");
	By linkMyUsage = By.xpath("//a[text()='My Usage']");
	By linkHelp = By.xpath("//a[text()='Help']");
	
	Screenshot screen = new Screenshot();
	
	public boolean pageAccessCheck(WebDriver driver) throws Exception
	{
		int homeSize = driver.findElements(linkHome).size();
		int accountSize = driver.findElements(linkMyAccount).size();
		int planSize = driver.findElements(linkMyPlans).size();
		int billsSize = driver.findElements(linkMyBills).size();
		int usageSize = driver.findElements(linkMyUsage).size();
		int helpSize = driver.findElements(linkHelp).size();
		boolean a = true;
		
		screen.getScreenshot(driver, "Access Check");
		
		if (homeSize == 0) {System.out.println("User Does not have access to home page"); a = false;} else System.out.println("User has access to Home page");
		if (accountSize == 0) {System.out.println("User Does not have access to My Account page"); a = false;} else System.out.println("User has access to My Accounts page");
		if (planSize == 0) {System.out.println("User Does not have access to My Plans page"); a = false;} else System.out.println("User has access to My Plans page");
		if (billsSize == 0) {System.out.println("User Does not have access to My Bills page"); a = false;} else System.out.println("User has access to My Bills page");
		if (usageSize == 0) {System.out.println("User Does not have access to My Usage page"); a = false;} else System.out.println("User has access to My Usage page");
		if (helpSize == 0) {System.out.println("User Does not have access to Help page"); a = false;} else System.out.println("User has access to Help page");
		
		return a;
	}

}
