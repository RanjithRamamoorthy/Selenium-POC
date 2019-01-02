package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation {
	
	By navPlus = By.xpath("//*[@id='AllTab_Tab']/a");
	By navLead = By.xpath(".//*[@id='ext-gen240']");
	By newLead = By.xpath(".//*[@id='00B28000007cWRb_listButtons']/ul/li[1]/input");
	
	By leadFName = By.xpath("//*[@id='LeadScoutPage:accountScoutForm:inputBlock:inputSection:j_id37:0:j_id38']");
	By leadLName = By.xpath("//*[@id='LeadScoutPage:accountScoutForm:inputBlock:inputSection:j_id37:1:j_id38']");
	By createLead = By.xpath("//*[@id='LeadScoutPage:accountScoutForm:inputBlock:j_id5:bottom:createButton']");
	By email = By.xpath("//*[@id='LeadScoutPage:accountScoutForm:inputBlock:inputSection:j_id37:2:j_id38']");
	By phone = By.xpath("//*[@id='LeadScoutPage:accountScoutForm:inputBlock:inputSection:j_id37:3:j_id38']");
	
	
	public void navigateToLead(WebDriver driver)
	{
		driver.findElement(navPlus).click();
		//driver.findElement(navLead).click();
		
	}
	public void createNewLead(WebDriver driver)
	{
		driver.findElement(newLead).click();
		driver.findElement(leadFName).sendKeys("Ranjith");
		driver.findElement(leadLName).sendKeys("Tester");
		driver.findElement(email).sendKeys("ranjith.ramamoorthy@hydro.com.au");
		driver.findElement(phone).sendKeys("0399999999");
		driver.findElement(createLead).click();
	}
}
