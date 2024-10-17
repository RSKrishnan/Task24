package org.DemoPageSample;

import java.time.Duration;
import org.POMSample.LoginPage;
import org.POMSample.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoPage {
	WebDriver driver;

	@BeforeTest
	public void mainPage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// URL is loaded using get method
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(groups = "signup", priority = 1)
	public void signUp() {
		// pagefactory initElement is used to get the xpath from the SignUpPage class
		PageFactory.initElements(driver, SignUpPage.class);
		// className followed by method name to call
		SignUpPage.login.click();
		SignUpPage.username.sendKeys("DemoSample");
		SignUpPage.password.sendKeys("Demo@123");
		SignUpPage.submit.click();
		// Used explicit wait until the alert is visible
		WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(20));
		wa.until(ExpectedConditions.alertIsPresent());
		// switched to alert for accept
		driver.switchTo().alert().accept();
		String tit = "STORE";
		// assertEquals is used to verify the page
		Assert.assertEquals(driver.getTitle(), tit);
	}

	@Test(groups = "login", priority = 2)
	public void login() throws InterruptedException {
		// pagefactory initElement is used to get the xpath inside the LoginPage class
		PageFactory.initElements(driver, LoginPage.class);
		// className followed by method name to call
		LoginPage.login.click();
		LoginPage.username.sendKeys("DemoSample");
		LoginPage.password.sendKeys("Demo@123");
		LoginPage.submit.click();
		String lg = "Log out";
		Thread.sleep(3000);
		// assertEquals is used to verify the page
		Assert.assertEquals(LoginPage.logout.getText(), lg);
	}

	@AfterTest
	public void close() {
		//to close the current page
		driver.close();
	}
}
