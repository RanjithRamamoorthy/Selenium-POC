package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalSearch {
	
	By txtGlobalSearch = By.xpath(".//*[@id='phSearchInput']");
	By firstAccountLink = By.xpath(".//*[@id='Account_body']/table/tbody/tr[2]/th/a");
	By firstBillingAccountLink = By.xpath(".//*[@id='BillingAccount__c_body']/table/tbody/tr[2]/th/a");
	By firstBillingAccountsAccountLink = By.xpath(".//*[@id='BillingAccount__c_body']/table/tbody/tr[2]/td[2]/a");
	
	
	public void searchText (WebDriver driver, String searchString)
	{
		driver.findElement(txtGlobalSearch).sendKeys(searchString);
		driver.findElement(txtGlobalSearch).sendKeys(Keys.ENTER);
	}
	//selecting the searched billing account's account
	public void searchedAccountSelect (WebDriver driver, String searchAccName) throws InterruptedException
	{
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(firstBillingAccountLink));
		String a = "\".//a[text()='"+searchAccName+"']\"";
		System.out.println("printing a:"+a);
		Thread.sleep(10000);
		driver.findElement(firstBillingAccountLink).click();
		Thread.sleep(10000);
	}

}
