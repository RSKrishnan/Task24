package org.POMSample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//@findBy method is used to get the xpath
	@FindBy(id="login2")
	public static WebElement login;
	
	@FindBy(id="loginusername")
	public static WebElement username;
	
	@FindBy(id="loginpassword")
	public static WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	public static WebElement submit;
	@FindBy(id="logout2")
	public static WebElement logout;
}
