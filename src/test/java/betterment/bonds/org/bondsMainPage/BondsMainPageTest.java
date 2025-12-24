package betterment.bonds.org.bondsMainPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;	
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import betterment.bonds.org.base.BaseTest;
import betterment.bonds.org.pageObjects.BettermentMainPage;
import betterment.bonds.org.pageObjects.BondsInvestingPage;
import betterment.bonds.org.utilities.TestDataConstants;
import betterment.bonds.org.extentListener.*;

@Listeners(ExtentTestListener.class)
public class BondsMainPageTest extends BaseTest {
	WebDriver driver;
	BettermentMainPage betMainPage;
	BondsInvestingPage bondsInvPage;

//  constructor from to set path of bonds page and get the driver from super class
	public BondsMainPageTest() throws IOException {
		super(TestDataConstants.BONDSURL);
		driver = super.getDriver();
	}

//	initialize test and send driver to BondsMainPage
	@BeforeTest
	public void initialize() {
		betMainPage = new BettermentMainPage(this.driver);
		bondsInvPage = new BondsInvestingPage(this.driver);
	}

	@Test
	public void verifyBondsInvestingLink() {

		if (betMainPage.cookiesPopUp.isDisplayed()) {
			betMainPage.cookieRejectAllButton.click();
			System.out.println("Cookie Pop Up detected and closed.");
		}

		betMainPage.clickElement(betMainPage.linkInvest);
		betMainPage.clickElement(betMainPage.linkBondsInvesting);
		Assert.assertEquals(driver.getCurrentUrl(), TestDataConstants.BONDSINVESTINGURL);
	}

	@Test
	public void verifyBondsInvestingPage() {
		// Verift that "bonds only" label is displayed	
		Assert.assertTrue(bondsInvPage.bondsOnlyLabel.isDisplayed());
	}

	// close the driver after test completes
	@AfterTest
	public void closeTest() {
		driver.close();
	}
}
