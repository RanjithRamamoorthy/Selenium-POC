package osu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OSUPortal {
	
	By txtPostCode = By.xpath(".//*[@id='Postcode']");
	By radioAddress = By.id("Address");
	By txtAddress = By.xpath("//*[@id='SiteFilters_AddressSearch']");
	By radioNMI = By.id("nmi-radio");
	By txtNMI = By.id("nmi-search");
	By btnSelectPlan = By.xpath(".//*[@id='electricity-plans']/div[2]/div/div/div/div[2]/div/div[2]/label/span");
	By btnProceed = By.xpath("/html/body/form/div[3]/div/div/main/section/div[8]/div/div/div/div/div/span/button/span");
	By radioNotMoving = By.id("not-moving");
	By txtServiceAddr = By.id("ServiceAddress_ServiceAddress");
	By selectTitle = By.id("PrimaryAccountholder_Title");
	By txtFirstName = By.id("first-name");
	By txtLastName = By.id("last-name");
	By txtPhone = By.id("phone");
	By txtMobile = By.id("mobile");
	By txtEmail = By.id("email");
	By txtConfirmEmail = By.id("confirm-email");
	By txtDOBDay = By.id("PrimaryAccountholder_DateOfBirth_Day");
	By txtDOBMonth = By.id("PrimaryAccountholder_DateOfBirth_Month");
	By txtDOBYear = By.id("PrimaryAccountholder_DateOfBirth_Year");
	By selectIDType = By.id("id-type");
	By txtIDNumber = By.id("IdentificationDetails_Number");
	By txtIDExpiryDay = By.id("IdentificationDetails_ExpiryDate_Day");
	By txtIDExpiryMonth = By.id("IdentificationDetails_ExpiryDate_Month");
	By txtIDExpiryYear = By.id("IdentificationDetails_ExpiryDate_Year");
	By btnEnterBillingDetails = By.id("enter-payment-details-cta");
	By radioInvoiceOnly = By.xpath("//*[@id='invoice-only']");
	By checkTermsConditions = By.id("SignupTermsAndConditions_TermsAndConditionsAccepted");
	By btnAgreeConfirm = By.xpath("/html/body/form/div[3]/div/div/main/section/div/div[6]/div/div/button/span");
	By selectAddress = By.xpath("//*[@id='choose-exact-meter-popup']/div/div/div[2]/div/div[2]/div[1]/label");
	By nextAddress = By.xpath("//*[@id='choose-exact-meter-popup']/div/div/div[3]/div/button");
	By secFN = By.id("SecondaryAccountholders_0__FirstName");
	By secLN = By.id("SecondaryAccountholders_0__LastName");
	By secDD = By.id("SecondaryAccountholders_0__DateOfBirth_Day");
	By secMM = By.id("SecondaryAccountholders_0__DateOfBirth_Month");
	By secYY = By.id("SecondaryAccountholders_0__DateOfBirth_Year");
	By secEmail = By.id("SecondaryAccountholders_0__Email");
	By secCEmail = By.id("SecondaryAccountholders_0__ConfirmEmail");
	
	
	public boolean osu(WebDriver driver, String NMI, String FN, String LN, String Email) throws InterruptedException {
		
		driver.findElement(txtPostCode).sendKeys("3008");
		driver.findElement(txtPostCode).sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		//driver.findElement(radioAddress).click();
		driver.findElement(radioNMI).click();
		Thread.sleep(1000);
		driver.findElement(txtNMI).sendKeys(NMI);
		//Thread.sleep(5000);
		driver.findElement(txtNMI).sendKeys(Keys.RETURN);
		//Thread.sleep(5000);
		//driver.findElement(txtNMI).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(btnSelectPlan).click();
		Thread.sleep(1000);
		driver.findElement(btnProceed).click();
		driver.findElement(radioNotMoving).click();
		//driver.findElement(txtServiceAddr).sendKeys("Shop 1  500 Bourke Street, MELBOURNE  VIC  3000");
		Thread.sleep(1000);
		driver.findElement(txtServiceAddr).sendKeys(Keys.RETURN);
		driver.findElement(selectTitle).sendKeys("Mr");
		driver.findElement(txtFirstName).sendKeys(FN);
		driver.findElement(txtLastName).sendKeys(LN);
		driver.findElement(txtPhone).sendKeys("0399999999");
		driver.findElement(txtMobile).sendKeys("0400000000");
		driver.findElement(txtEmail).sendKeys(Email);
		driver.findElement(txtConfirmEmail).sendKeys(Email);
		driver.findElement(txtDOBDay).sendKeys("01");
		driver.findElement(txtDOBMonth).sendKeys("01");
		driver.findElement(txtDOBYear).sendKeys("1991");
		driver.findElement(selectIDType).sendKeys("passport");
		driver.findElement(txtIDNumber).sendKeys("121334P");
		driver.findElement(txtIDExpiryDay).sendKeys("01");
		driver.findElement(txtIDExpiryMonth).sendKeys("01");
		driver.findElement(txtIDExpiryYear).sendKeys("2030");

		//Secondary contact
		
		driver.findElement(secFN).sendKeys("Auth");
		driver.findElement(secLN).sendKeys("Cont");
		driver.findElement(secDD).sendKeys("02");
		driver.findElement(secMM).sendKeys("02");
		driver.findElement(secYY).sendKeys("1988");
		driver.findElement(secEmail).sendKeys("test.momentum@momentum.com");
		driver.findElement(secCEmail).sendKeys("test.momentum@momentum.com");
		
		
		driver.findElement(btnEnterBillingDetails).click();

		//driver.findElement(selectAddress).click();
		//driver.findElement(nextAddress).click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(radioInvoiceOnly));
		driver.findElement(radioInvoiceOnly).click(); 
		driver.findElement(checkTermsConditions).click();
		driver.findElement(btnAgreeConfirm).click();
		
		//System.out.println("OSU is Successful");
		String a = driver.getCurrentUrl();
		String b = "https://qa.momentumenergy.com.au/switch/thank-you";
		
		if(a.equalsIgnoreCase(b))
		{
			System.out.println("OSU is successful");
			return true;
		}
		else
		{
			System.out.println("OSU is unsuccessful");
			return false;
		}
		
		
		
	}


}
