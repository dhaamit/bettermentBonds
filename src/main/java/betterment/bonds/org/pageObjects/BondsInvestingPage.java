package betterment.bonds.org.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BondsInvestingPage {

	WebDriver driver;
	Wait<WebDriver> wait;

	public BondsInvestingPage(WebDriver driver)
	    {
	        this.driver = driver;
	        PageFactory.initElements(this.driver, this);
	        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
	    }

	@FindBy(xpath = "//span[normalize-space()='Bonds only']")
	public WebElement bondsOnlyLabel;

}
