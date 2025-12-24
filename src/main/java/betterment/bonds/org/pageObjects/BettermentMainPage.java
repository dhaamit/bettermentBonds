//Author - @Amit Dharmale
package betterment.bonds.org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BettermentMainPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    public BettermentMainPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
    }

    @FindBy(xpath="//h1[normalize-space()='United States Rates & Bonds']")
    public WebElement bondsHeader;

    @FindBy(xpath="//a[@href='/markets/rates-bonds']")
    public WebElement linkRatesAndBonds;
    
    @FindBy(id="ketch-consent-banner")
    public WebElement cookiesPopUp;
    
    @FindBy(xpath="//button[@aria-label='Reject All']")
    public WebElement cookieRejectAllButton;
    
    @FindBy(xpath="//a[normalize-space()='Invest']")
    public WebElement linkInvest;
  
    @FindBy(xpath="//div[contains(text(),'Bond investing')]")
    public WebElement linkBondsInvesting;
    
    public void clickElement(WebElement element){
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    
}
